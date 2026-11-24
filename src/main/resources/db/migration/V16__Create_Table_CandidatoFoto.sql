DROP VIEW IF EXISTS listarCandidatos;

ALTER TABLE candidato DROP COLUMN IF EXISTS can_foto;

CREATE TABLE candidatofoto (
    cft_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cft_dados BYTEA NOT NULL,
    cft_tipo VARCHAR(50) NOT NULL,
    can_id UUID,
    CONSTRAINT fk_candidato_foto FOREIGN KEY (can_id) REFERENCES candidato(can_id),
    atualizadoem DATE
);

CREATE OR REPLACE VIEW listarCandidatos AS
SELECT candidato.can_id AS idCandidato,
	   candidato.can_nomesocial AS nomesocial,
	   cargo.car_id AS cargoId,
	   cargo.car_nome AS nomecargo,
	   partido.par_id AS partidoId,
	   partido.par_sigla AS nomepartido,
	   partido.par_numero AS numeropartido
FROM candidato
	INNER JOIN partido USING (par_id)
	INNER JOIN cargo USING (car_id)