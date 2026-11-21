CREATE PROCEDURE cadastrarUsuario(
	nome VARCHAR(60),
	sobrenome VARCHAR(150),
	email VARCHAR(220),
	hash VARCHAR(24),
	tipo VARCHAR(6)
)
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO usuario(usu_nome, usu_sobrenome, usu_email, usu_senha_hash, usu_tipo, criadoem, atualizadoem)
	VALUES(nome, sobrenome, email, hash, tipo, current_date, current_date);
END;
$$;