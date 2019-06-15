CREATE TABLE ng.usuario (
    id bigint PRIMARY KEY,
    nome text NOT NULL,
    login text UNIQUE NOT NULL,
    senha text NOT NULL
);