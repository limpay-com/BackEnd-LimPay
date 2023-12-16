CREATE TABLE conta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    chavePix VARCHAR(255) NOT NULL,
    valor DOUBLE,
    saldo DOUBLE
);

CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    dataNascimento DATE,
    numeroCelular VARCHAR(20),
    cep VARCHAR(10),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2),
    numeroCasa VARCHAR(10),
    chavePix VARCHAR(255)
);

CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tokenRecuperacaoSenha VARCHAR(255)
);

CREATE TABLE localizacao (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

CREATE TABLE contrato (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    txtAreaContrato TEXT,
    contratoGerado BOOLEAN,
    conteudoContrato TEXT
);


CREATE TABLE Curso (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE video (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    completo BOOLEAN,
    curso_id BIGINT,
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);

CREATE TABLE usario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL
);