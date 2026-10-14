package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.TipoUsuario;
import com.dadoLivre.api.model.Usuario;
import com.dadoLivre.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // RF10 - Cadastro de usuário via e-mail
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        try {
            // ✅ CORRIGIDO: tipoUsuario sempre ELEITOR — nunca deixar o cliente definir isso
            usuario.setTipoUsuario(TipoUsuario.ELEITOR);

            // Criptografa a senha antes de salvar (RN03)
            usuario.setSenha(encoder.encode(usuario.getSenha()));

            Usuario salvo = repository.save(usuario);
            salvo.setSenha(null); // nunca expõe o hash na resposta
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

        } catch (DataIntegrityViolationException e) {
            String causa = e.getMostSpecificCause().getMessage();
            System.err.println("Falha ao cadastrar usuário: " + causa);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("erro", "E-mail já cadastrado."));
        }
    }

    // RF21 - Listagem de usuários (somente ADMIN)
    @GetMapping
    public List<Usuario> listar() {
        List<Usuario> usuarios = repository.findAll();
        usuarios.forEach(u -> u.setSenha(null)); // nunca expõe hashes na listagem
        return usuarios;
    }

    // RF17 / RF31 - Atualização de dados do usuário
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Usuario dados) {
        return repository.findById(id).map(usuario -> {
            usuario.setNome(dados.getNome());
            // E-mail só atualiza se vier no body e for diferente
            if (dados.getEmail() != null && !dados.getEmail().isBlank()) {
                usuario.setEmail(dados.getEmail());
            }
            // Senha só atualiza se vier preenchida
            if (dados.getSenha() != null && !dados.getSenha().isBlank()) {
                usuario.setSenha(encoder.encode(dados.getSenha()));
            }
            Usuario atualizado = repository.save(usuario);
            atualizado.setSenha(null);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // RF27 - Exclusão de conta pelo próprio usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
