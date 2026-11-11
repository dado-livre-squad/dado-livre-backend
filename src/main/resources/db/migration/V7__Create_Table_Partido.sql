CREATE TABLE partido(
    par_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    par_nome VARCHAR(200),
    par_sigla CHAR(4),
    par_numero INT,
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL,
    enc_id UUID,
    col_id UUID,
    sit_id UUID,
    CONSTRAINT fk_partido_encarregadodados FOREIGN KEY (enc_id) REFERENCES encarregadodados(enc_id),
    CONSTRAINT fk_partido_coligacao FOREIGN KEY (col_id) REFERENCES coligacao(col_id),
    CONSTRAINT fk_partido_situacao FOREIGN KEY (sit_id) REFERENCES situacao(sit_id)
);