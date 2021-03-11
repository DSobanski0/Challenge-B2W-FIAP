/*Integrantes
Alex Yuji Vieira Isomoura - RM 84432 
Daniel de Oliveira Sobanski - RM 84281
Denys Lonkovski Maiolli - RM 86487
Edson de Oliveira - RM 84361
Ruan Vieira da Silva - RM 85631*/


/*DROP TABLE t_skt_cargo CASCADE CONSTRAINTS;

DROP TABLE t_skt_func_cargo CASCADE CONSTRAINTS;

DROP TABLE t_skt_func_cargo_question CASCADE CONSTRAINTS;

DROP TABLE t_skt_funcionario CASCADE CONSTRAINTS;

DROP TABLE t_skt_question_questoes CASCADE CONSTRAINTS;

DROP TABLE t_skt_questionario CASCADE CONSTRAINTS;

DROP TABLE t_skt_questoes CASCADE CONSTRAINTS;

DROP TABLE t_skt_respostas CASCADE CONSTRAINTS;*/

CREATE TABLE t_skt_cargo (
    cd_cargo  NUMBER(4) NOT NULL,
    nm_cargo  VARCHAR2(80) NOT NULL
);

ALTER TABLE t_skt_cargo ADD CONSTRAINT pk_skt_cargo PRIMARY KEY ( cd_cargo );

CREATE TABLE t_skt_func_cargo (
    cd_func_cargo   NUMBER(8) NOT NULL,
    cd_funcionario  NUMBER(6) NOT NULL,
    cd_cargo        NUMBER(4) NOT NULL,
    dt_entrada      DATE NOT NULL,
    dt_saida        DATE
);

ALTER TABLE t_skt_func_cargo ADD CONSTRAINT pk_skt_func_cargo PRIMARY KEY ( cd_func_cargo );

CREATE TABLE t_skt_func_cargo_question (
    cd_func_cargo_quest  NUMBER(10) NOT NULL,
    cd_func_cargo        NUMBER(8) NOT NULL,
    cd_questionario      NUMBER(8) NOT NULL,
    dt_inicio            DATE NOT NULL,
    dt_termino           DATE NOT NULL
);

ALTER TABLE t_skt_func_cargo_question ADD CONSTRAINT pk_skt_func_cargo_question PRIMARY KEY ( cd_func_cargo_quest );

CREATE TABLE t_skt_funcionario (
    cd_funcionario  NUMBER(6) NOT NULL,
    nm_funcionario  VARCHAR2(50) NOT NULL,
    dt_nascimento   DATE NOT NULL,
    ds_email        VARCHAR2(70) NOT NULL,
    nr_cpf          NUMBER(11) NOT NULL,
    ds_tipo_func    VARCHAR2(12) NOT NULL
);

ALTER TABLE t_skt_funcionario ADD CONSTRAINT pk_skt_funcionario PRIMARY KEY ( cd_funcionario );

CREATE TABLE t_skt_question_questoes (
    cd_question_questao  NUMBER(10) NOT NULL,
    cd_questionario      NUMBER(8) NOT NULL,
    cd_questao           NUMBER(10) NOT NULL
);

ALTER TABLE t_skt_question_questoes ADD CONSTRAINT pk_skt_question_questoes PRIMARY KEY ( cd_question_questao );

CREATE TABLE t_skt_questionario (
    cd_questionario  NUMBER(8) NOT NULL,
    ds_questionario  VARCHAR2(200) NOT NULL
);

ALTER TABLE t_skt_questionario ADD CONSTRAINT pk_skt_questionario PRIMARY KEY ( cd_questionario );

CREATE TABLE t_skt_questoes (
    cd_questao       NUMBER(10) NOT NULL,
    ds_questao       VARCHAR2(300) NOT NULL,
    vl_peso_questao  NUMBER(2) NOT NULL,
    ds_tipo_questao  VARCHAR2(12) NOT NULL
);

ALTER TABLE t_skt_questoes ADD CONSTRAINT pk_skt_questoes PRIMARY KEY ( cd_questao );

CREATE TABLE t_skt_respostas (
    cd_resposta          NUMBER(10) NOT NULL,
    cd_func_cargo_quest  NUMBER(10) NOT NULL,
    cd_question_questao  NUMBER(10) NOT NULL,
    ds_resposta          VARCHAR2(10) NOT NULL,
    dt_resposta          DATE NOT NULL
);

ALTER TABLE t_skt_respostas ADD CONSTRAINT pk_skt_respostas PRIMARY KEY ( cd_resposta );

ALTER TABLE t_skt_func_cargo
    ADD CONSTRAINT fk_cargo_funcionario FOREIGN KEY ( cd_cargo )
        REFERENCES t_skt_cargo ( cd_cargo );

ALTER TABLE t_skt_func_cargo_question
    ADD CONSTRAINT fk_func_cargo_question FOREIGN KEY ( cd_func_cargo )
        REFERENCES t_skt_func_cargo ( cd_func_cargo );

ALTER TABLE t_skt_respostas
    ADD CONSTRAINT fk_func_cargo_question_resp FOREIGN KEY ( cd_func_cargo_quest )
        REFERENCES t_skt_func_cargo_question ( cd_func_cargo_quest );

ALTER TABLE t_skt_func_cargo
    ADD CONSTRAINT fk_funcionario_cargo FOREIGN KEY ( cd_funcionario )
        REFERENCES t_skt_funcionario ( cd_funcionario );

ALTER TABLE t_skt_question_questoes
    ADD CONSTRAINT fk_questao_question FOREIGN KEY ( cd_questao )
        REFERENCES t_skt_questoes ( cd_questao );

ALTER TABLE t_skt_func_cargo_question
    ADD CONSTRAINT fk_question_func_cargo FOREIGN KEY ( cd_questionario )
        REFERENCES t_skt_questionario ( cd_questionario );

ALTER TABLE t_skt_question_questoes
    ADD CONSTRAINT fk_question_questoes FOREIGN KEY ( cd_questionario )
        REFERENCES t_skt_questionario ( cd_questionario );

ALTER TABLE t_skt_respostas
    ADD CONSTRAINT fk_question_questoes_resp FOREIGN KEY ( cd_question_questao )
        REFERENCES t_skt_question_questoes ( cd_question_questao );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             16
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
