package com.dadoLivre.api.service;

import com.dadoLivre.api.model.Candidato;
import com.dadoLivre.api.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    // RF24 - Importação de candidatos via CSV (recebe MultipartFile do controller)
    public List<Candidato> importarCsv(MultipartFile arquivo) throws Exception {
        List<Candidato> importados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(arquivo.getInputStream()))) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) { // Pula cabeçalho
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(",");
                if (dados.length >= 5) {
                    Candidato c = new Candidato();
                    c.setNome(dados[0].trim());
                    c.setPartido(dados[1].trim());
                    c.setCargo(dados[2].trim());
                    c.setEstado(dados[3].trim());
                    c.setCidade(dados[4].trim());
                    c.setUltimaAtualizacao(LocalDate.now());
                    candidatoRepository.save(c);
                    importados.add(c);
                }
            }
        }

        return importados;
    }
}
