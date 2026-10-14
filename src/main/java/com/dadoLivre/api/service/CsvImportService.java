package com.dadoLivre.api.service;

import com.dadoLivre.api.model.Candidato;
import com.dadoLivre.api.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

@Service
public class CsvImportService implements CommandLineRunner {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Evita duplicar se o banco já tiver registros
        if (candidatoRepository.count() > 0) {
            System.out.println("ℹ️ Banco já possui candidatos — importação CSV ignorada.");
            return;
        }

        // ✅ CORRIGIDO: verifica se o arquivo existe antes de tentar ler
        InputStream is = getClass().getResourceAsStream("/data/candidatos.csv");
        if (is == null) {
            System.out.println("ℹ️ Arquivo /data/candidatos.csv não encontrado — nenhum dado importado na inicialização.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            String linha;
            boolean primeiraLinha = true;
            int importados = 0;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Pula o cabeçalho
                }

                // Remove aspas e divide por ";"
                String[] dados = linha.replace("\"", "").split(";");

                // Garante colunas suficientes
                if (dados.length > 21) {
                    Candidato candidato = new Candidato();
                    candidato.setNome(dados[11].trim());      // NM_CANDIDATO
                    candidato.setCargo(dados[8].trim());      // DS_CARGO
                    candidato.setPartido(dados[21].trim());   // SG_PARTIDO
                    candidato.setEstado(dados[4].trim());     // SG_UF
                    candidato.setCidade(dados[6].trim());     // NM_UE
                    candidato.setUltimaAtualizacao(LocalDate.now());
                    candidatoRepository.save(candidato);
                    importados++;
                }
            }

            System.out.println("✅ Importação CSV concluída: " + importados + " candidato(s) importado(s).");

        } catch (Exception e) {
            // ✅ CORRIGIDO: erro no CSV não derruba a aplicação
            System.err.println("⚠️ Erro ao processar o CSV: " + e.getMessage());
        }
    }
}
