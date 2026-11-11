CREATE TABLE encarregadodados(
    enc_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    enc_nome VARCHAR(150),
    par_id UUID,
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);