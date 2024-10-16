CREATE TABLE "CONTATO"
(
    "ID"       NUMBER PRIMARY KEY,
    "NOME"     VARCHAR2(128) NOT NULL,
    "EMAIL"    VARCHAR2(512) NOT NULL,
    "TELEFONE" VARCHAR2(11)  NOT NULL
);

CREATE TABLE "CATEGORIA"
(
    "ID"           NUMBER PRIMARY KEY,
    "DESCRICAO"    VARCHAR2(128) NOT NULL,
    "VALOR_LIMITE" NUMBER(10, 4) NOT NULL,
    "CONTATO_ID"   NUMBER
);

CREATE TABLE "EVENTO"
(
    "ID"           NUMBER PRIMARY KEY,
    "OCORRENCIA"   TIMESTAMP(6)  NOT NULL,
    "CRITICIDADE"  VARCHAR2(20)  NOT NULL,
    "DESCRICAO"    VARCHAR2(128) NOT NULL,
    "CATEGORIA_ID" NUMBER,
    "REGIAO"       NUMBER        NOT NULL
);

CREATE TABLE "IRRIGACAO"
(
    "ID"              NUMBER PRIMARY KEY,
    "REGIAO"          NUMBER       NOT NULL,
    "NIVEL_AGUA"      NUMBER       NOT NULL,
    "INICIO"          TIMESTAMP(6) NOT NULL,
    "DURACAO_MINUTOS" NUMBER       NOT NULL
);

CREATE TABLE "MONITORAMENTO"
(
    "ID"           NUMBER PRIMARY KEY,
    "OCORRENCIA"   TIMESTAMP(6)  NOT NULL,
    "REGIAO"       NUMBER        NOT NULL,
    "VALOR_MEDIDO" NUMBER(10, 4) NOT NULL,
    "CATEGORIA_ID" NUMBER
);


ALTER TABLE "CATEGORIA"
    ADD CONSTRAINT "FK_CONTATO_ID" FOREIGN KEY ("CONTATO_ID")
        REFERENCES "CONTATO" ("ID") ENABLE;

ALTER TABLE "EVENTO"
    ADD CONSTRAINT "FK_EVENTO_CATEGORIA_ID" FOREIGN KEY ("CATEGORIA_ID")
        REFERENCES "CATEGORIA" ("ID") ENABLE;

ALTER TABLE "MONITORAMENTO"
    ADD CONSTRAINT "FK_MONITORAMENTO_CATEGORIA_ID" FOREIGN KEY ("CATEGORIA_ID")
        REFERENCES "CATEGORIA" ("ID") ENABLE;

CREATE SEQUENCE CONTATO_SEQ;

CREATE SEQUENCE CATEGORIA_SEQ;

CREATE SEQUENCE EVENTO_SEQ;

CREATE SEQUENCE IRRIGACAO_SEQ;

CREATE SEQUENCE MONITORAMENTO_SEQ;
