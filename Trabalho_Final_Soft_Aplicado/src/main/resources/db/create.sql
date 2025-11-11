CREATE TABLE tb_ticket (
    codigo VARCHAR(36) PRIMARY KEY,
    entrada TIMESTAMP NOT NULL,
    placa VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL
);