-- Criar o banco de dados
CREATE DATABASE cadastro_clientes;

-- Usar o banco de dados
USE cadastro_clientes;

-- Criar a tabela cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    endereco VARCHAR(255) NOT NULL
);
