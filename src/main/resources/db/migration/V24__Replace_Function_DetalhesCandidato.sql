DROP FUNCTION IF EXISTS detalhesCandidato(uuid);

CREATE OR REPLACE FUNCTION detalhesCandidato(idCandidato UUID)
RETURNS TABLE(
	id UUID,
	nomeSocial VARCHAR(200),
	sobre VARCHAR(1000),
	idade NUMERIC,
	estado CHAR(2),
	partido VARCHAR(200),
	numeroPartido INT,
	cargo VARCHAR(70),
	tipoCargo VARCHAR(10)
)
LANGUAGE plpgsql
AS $$
#variable_conflict use_column
BEGIN
	RETURN QUERY
	SELECT candidato.can_id AS id,
	       candidato.can_nomesocial AS nomesocial,
	       candidato.can_sobre AS sobre,
	       EXTRACT(YEAR FROM AGE(CURRENT_DATE, candidato.can_datanascimento))::numeric AS idade,
	       estado.est_sigla AS estado,
	       partido.par_sigla AS partido,
	       partido.par_numero::int AS numeropartido,
	       cargo.car_nome AS cargo,
	       cargo.car_tipo AS tipocargo
	FROM candidato
		INNER JOIN partido USING (par_id)
		INNER JOIN estado USING (est_id)
		INNER JOIN cargo USING (car_id)
	WHERE candidato.can_id = idCandidato;
END;
$$;