CREATE TABLE tipobem(
    tpb_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tpb_nome VARCHAR(200),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);