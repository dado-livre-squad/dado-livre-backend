CREATE TABLE estado(
    est_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    est_nome VARCHAR(19) NOT NULL,
    est_sigla CHAR(2) NOT NULL,
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);