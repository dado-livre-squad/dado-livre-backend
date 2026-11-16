DROP VIEW IF EXISTS listarCandidatos;

CREATE OR REPLACE VIEW listarCandidatos AS
SELECT candidato.can_id AS idCandidato,
	   candidato.can_nomesocial AS nomesocial,
	   cargo.car_id AS cargoId,
	   cargo.car_nome AS nomecargo,
	   partido.par_id AS partidoId,
	   partido.par_nome AS nomepartido,
	   partido.par_sigla AS siglapartido,
	   partido.par_numero AS numeropartido
FROM candidato
	INNER JOIN partido USING (par_id)
	INNER JOIN cargo USING (car_id);