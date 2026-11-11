CREATE TABLE redesocial(
    red_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    red_endereco VARCHAR(200),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL,
    can_id UUID,
    CONSTRAINT fk_redesocial_candidato FOREIGN KEY (can_id) REFERENCES candidato(can_id)
);