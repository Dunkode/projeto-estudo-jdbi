CREATE TABLE cliente
(
    id              UUID PRIMARY KEY,
    nome            VARCHAR(200) NOT NULL,
    email           VARCHAR(200) NOT NULL UNIQUE,
    telefone        VARCHAR(30),
    data_nascimento DATE,
    ativo           BOOLEAN      NOT NULL DEFAULT TRUE,
    data_criacao    TIMESTAMP             DEFAULT now()
);