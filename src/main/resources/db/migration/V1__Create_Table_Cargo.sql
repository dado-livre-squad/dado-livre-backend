CREATE TABLE cargo(
    car_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    car_nome VARCHAR(70) NOT NULL,
    car_tempo_duracao INT NOT NULL,
    criadoEm DATE NOT NULL,
    atualizadoEm DATE NOT NULL
);