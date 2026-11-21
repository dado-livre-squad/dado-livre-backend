CREATE FUNCTION usuarioPorEmail(emailUsuario VARCHAR(220))
RETURNS TABLE(
	email VARCHAR(220),
	senha VARCHAR(70)
)
LANGUAGE plpgsql
AS $$
BEGIN
	RETURN QUERY
	SELECT usuario.usu_email AS email,
		   usuario.usu_senha_hash AS senha
	FROM usuario
	WHERE usuario.usu_email = emailUsuario;
END;
$$;