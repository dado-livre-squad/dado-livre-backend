CREATE FUNCTION fotoCandidato(id_candidato UUID)
RETURNS TABLE(id UUID, foto BYTEA, tipo VARCHAR(50))
LANGUAGE plpgsql
AS $$
BEGIN
	RETURN QUERY
	SELECT candidatofoto.cft_id AS id,
	       candidatofoto.cft_dados AS foto,
	       candidatofoto.cft_tipo AS tipo
	FROM candidatofoto
	WHERE candidatofoto.can_id = id_candidato;
END;
$$;