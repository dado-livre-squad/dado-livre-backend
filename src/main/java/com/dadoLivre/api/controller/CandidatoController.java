package com.dadoLivre.api.controller;

import com.dadoLivre.api.model.Candidato;
import com.dadoLivre.api.repository.CandidatoRepository;
import com.dadoLivre.api.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private CandidatoService candidatoService;

    // RF01 - Listar todos os candidatos
    @GetMapping
    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    // RF04 + RF05 - Busca e filtro de candidatos
    // ✅ CORRIGIDO: agora aplica os filtros recebidos de verdade
    @GetMapping("/buscar")
    public ResponseEntity<List<Candidato>> buscarCandidatos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String partido,
            @RequestParam(required = false) String cargo,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String cidade) {

        // Validação: ao menos um critério deve ser informado
        boolean semCriterio = (nome == null || nome.isBlank())
                && (partido == null || partido.isBlank())
                && (cargo == null || cargo.isBlank())
                && (estado == null || estado.isBlank())
                && (cidade == null || cidade.isBlank());

        if (semCriterio) {
            return ResponseEntity.badRequest().build();
        }

        // Prioridade: nome > partido > cargo > estado > cidade
        if (nome != null && !nome.isBlank()) {
            return ResponseEntity.ok(candidatoRepository.findByNomeContainingIgnoreCase(nome));
        }
        if (partido != null && !partido.isBlank()) {
            return ResponseEntity.ok(candidatoRepository.findByPartidoIgnoreCase(partido));
        }
        if (cargo != null && !cargo.isBlank()) {
            return ResponseEntity.ok(candidatoRepository.findByCargoIgnoreCase(cargo));
        }
        if (estado != null && !estado.isBlank()) {
            return ResponseEntity.ok(candidatoRepository.findByEstadoIgnoreCase(estado));
        }

        return ResponseEntity.ok(candidatoRepository.findByCidadeIgnoreCase(cidade));
    }

    // RF06 - Perfil completo do candidato
    @GetMapping("/{id}")
    public ResponseEntity<Candidato> buscarPorId(@PathVariable Long id) {
        return candidatoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // RF02 - Edição de dados do candidato (somente ADMIN)
    @PutMapping("/{id}")
    public ResponseEntity<Candidato> atualizar(
            @PathVariable Long id,
            @RequestBody Candidato dados) {

        return candidatoRepository.findById(id).map(candidato -> {
            candidato.setNome(dados.getNome());
            candidato.setPartido(dados.getPartido());
            candidato.setCargo(dados.getCargo());
            candidato.setEstado(dados.getEstado());
            candidato.setCidade(dados.getCidade());
            candidato.setBiografia(dados.getBiografia());
            candidato.setPropostas(dados.getPropostas());
            candidato.setFotoUrl(dados.getFotoUrl());
            candidato.setSituacaoJuridica(dados.getSituacaoJuridica());
            candidato.setUltimaAtualizacao(LocalDate.now());
            return ResponseEntity.ok(candidatoRepository.save(candidato));
        }).orElse(ResponseEntity.notFound().build());
    }

    // RF03 - Exclusão de candidato (somente ADMIN)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!candidatoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        candidatoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // RF24 - Importação de candidatos via CSV (somente ADMIN)
    @PostMapping("/importar-csv")
    public ResponseEntity<?> importarCsv(@RequestParam("arquivo") MultipartFile arquivo) {
        try {
            List<Candidato> importados = candidatoService.importarCsv(arquivo);
            return ResponseEntity.ok(importados);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Erro ao processar CSV: " + e.getMessage());
        }
    }
}
