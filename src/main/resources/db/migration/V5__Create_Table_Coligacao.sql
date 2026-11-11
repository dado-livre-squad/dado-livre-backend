CREATE TABLE coligacao(
    col_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    col_nome VARCHAR(200),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);