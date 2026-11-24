CREATE FUNCTION nomeUsuario(email VARCHAR)
RETURNS TABLE(nomeUsuario VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
	RETURN QUERY
	SELECT usuario.usu_nome as nome
	FROM usuario
	WHERE usuario.usu_email = email;
END;
$$;