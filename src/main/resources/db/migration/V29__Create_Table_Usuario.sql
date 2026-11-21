CREATE TABLE usuario(
	usu_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	usu_nome varchar(60),
	usu_sobrenome varchar(150),
	usu_email varchar(220) UNIQUE,
	usu_senha_hash varchar(24),
    usu_tipo VARCHAR(6),
	criadoem date,
	atualizadoem date
);