DROP FUNCTION redeSocialCandidato;

CREATE OR REPLACE FUNCTION redeSocialCandidato(idCandidato UUID)
RETURNS TABLE(
	idRede UUID,
	endereco VARCHAR(200),
	nome VARCHAR(30),
    usuario VARCHAR(50)
)
LANGUAGE plpgsql
AS $$
BEGIN
	RETURN QUERY
	SELECT redesocial.red_id AS idRede,
	   redesocial.red_endereco AS endereco,
	   redesocial.red_nome AS nome,
	   redesocial.red_usuario AS usuario
	FROM redesocial
		INNER JOIN candidato USING (can_id)
	WHERE candidato.can_id = idCandidato;
END;
$$;