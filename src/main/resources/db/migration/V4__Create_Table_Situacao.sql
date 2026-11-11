CREATE TABLE situacao(
    sit_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sit_tipo VARCHAR(200),
    sit_descricao VARCHAR(1000),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);