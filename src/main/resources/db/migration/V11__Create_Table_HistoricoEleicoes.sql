CREATE TABLE historicoelecoes(
    his_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    his_ano CHAR(4),
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL,
    can_id UUID,
    car_id UUID,
    sit_id UUID,
    par_id UUID,
    CONSTRAINT fk_historico_candidato FOREIGN KEY (can_id) REFERENCES candidato(can_id),
    CONSTRAINT fk_historico_cargo FOREIGN KEY (car_id) REFERENCES cargo(car_id),
    CONSTRAINT fk_historico_situacao FOREIGN KEY (sit_id) REFERENCES situacao(sit_id),
    CONSTRAINT fk_historico_partido FOREIGN KEY (par_id) REFERENCES partido(par_id)
);