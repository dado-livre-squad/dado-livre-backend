CREATE TABLE bens(
    ben_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ben_nome VARCHAR(200),
    ben_sigla CHAR(4),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL,
    tpb_id UUID,
    can_id UUID,
    CONSTRAINT fk_bens_tipobem FOREIGN KEY (tpb_id) REFERENCES tipobem(tpb_id),
    CONSTRAINT fk_bens_candidato FOREIGN KEY (can_id) REFERENCES candidato(can_id)
);