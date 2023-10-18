DROP DATABASE IF EXISTS EscolaCECOI;
CREATE DATABASE EscolaCECOI CHARACTER SET utf8 COLLATE utf8_general_ci;
USE EscolaCECOI;

CREATE TABLE TURMA (
    trm_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    trm_perido ENUM('Matutino', 'Vespertino', 'Noturno'),
    trm_nome VARCHAR(20) NOT NULL
);

CREATE TABLE USUARIO (
    usr_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    usr_login VARCHAR(255),
    usr_senha VARCHAR(255),
/*    usr_permissao_sistema VARCHAR(10), */
    usr_email VARCHAR(100),
    usr_rg VARCHAR(12) NOT NULL,
    usr_cpf VARCHAR(15) NOT NULL,
    usr_nome VARCHAR(50) NOT NULL,
    usr_sexo ENUM('Masculino', 'Feminino'),
    usr_data_nascimento DATE NOT NULL
);

CREATE TABLE PERMISSAO (
	per_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	per_nome VARCHAR(15) NOT NULL
);

CREATE TABLE USUARIO_PERMISSAO(
	per_fk INT NOT NULL,
	usr_fk INT NOT NULL,
	FOREIGN KEY (per_fk) REFERENCES PERMISSAO(per_pk),
	FOREIGN KEY (usr_fk) REFERENCES USUARIO(usr_pk),
	PRIMARY KEY (per_fk, usr_fk)
);

CREATE TABLE RESPONSAVEL (
    res_pk INT PRIMARY KEY AUTO_INCREMENT,
    -- res_alu_fk INT NOT NULL,
    -- res_tel_fk INT NOT NULL,
    -- res_end_fk INT NOT NULL,
    res_rg VARCHAR(12) NOT NULL,
    res_cpf VARCHAR(15) NOT NULL,
    res_nome VARCHAR(50) NOT NULL,
    res_grau_parentesco VARCHAR(15) NOT NULL,
    res_sexo ENUM('Masculino', 'Feminino'),     
    res_data_nascimento DATE NOT NULL,
    res_profissao VARCHAR(50),
    res_email VARCHAR(100)
    -- FOREIGN KEY(res_alu_fk) REFERENCES ALUNO (alu_pk)
    
    -- FOREIGN KEY(res_tel_fk) REFERENCES TELEFONE (tel_pk),
    -- FOREIGN KEY(res_end_fk) REFERENCES ENDERECO (end_pk)
);

CREATE TABLE ALUNO (
    alu_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    alu_res_fk INT NOT NULL,
    alu_trm_fk INT NOT NULL,
    alu_nome VARCHAR(50) NOT NULL,
    alu_sexo ENUM('Masculino', 'Feminino'),
    alu_cor VARCHAR(10),
    alu_data_nascimento DATE NOT NULL,
    alu_numero_irmaos INT,
    FOREIGN KEY (alu_trm_fk) REFERENCES TURMA(trm_pk),
    FOREIGN KEY (alu_res_fk) REFERENCES RESPONSAVEL(res_pk)
);

-- CREATE TABLE ALUNO_TURMA (
-- 	alu_fk INT NOT NULL,
--     trm_fk INT NOT NULL,
    
--     FOREIGN KEY (alu_fk) REFERENCES ALUNO(alu_pk),
--     FOREIGN KEY (trm_fk) REFERENCES TURMA(trm_pk),
--     PRIMARY KEY (alu_fk, trm_fk)
-- );

CREATE TABLE DOENCA (
    dnc_pk INT PRIMARY KEY AUTO_INCREMENT,
    dnc_alu_fk INT NOT NULL,
    dnc_nome VARCHAR(20) NOT NULL,
    dnc_descricao VARCHAR(500) NOT NULL,
    FOREIGN KEY (dnc_alu_fk) REFERENCES ALUNO (alu_pk)
);

CREATE TABLE ENDERECO (
    end_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    end_rua VARCHAR(50) NOT NULL,
    end_numero INT NOT NULL,
    end_complemento VARCHAR(50),
    end_bairro VARCHAR(50) NOT NULL,    
    end_cep VARCHAR(10) NOT NULL,
    end_cidade VARCHAR(50) NOT NULL,  
    end_edr_uf VARCHAR(2) NOT NULL,
    
    end_tipo ENUM('Particular', 'Profissional'),
    
    -- Pode ser do responsável ou mesmo do usuário
    end_usr_fk INT,
    end_res_fk INT,
    
    FOREIGN KEY (end_usr_fk) REFERENCES USUARIO (usr_pk),
    FOREIGN KEY (end_res_fk) REFERENCES RESPONSAVEL (res_pk)
);

CREATE TABLE TELEFONE (
    tel_pk INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  
    tel_tipo ENUM('Residencial', 'Movel', 'Profissional'),
    tel_numero VARCHAR(15),
    
    -- Pode ser de responsável ou Usuário
    tel_usr_fk INT,
    tel_res_fk INT,
    
    FOREIGN KEY (tel_usr_fk) REFERENCES USUARIO (usr_pk),
    FOREIGN KEY (tel_res_fk) REFERENCES RESPONSAVEL (res_pk)
);

INSERT INTO USUARIO VALUES(1,'admin','$2a$10$2lGYpoBVN3z2OAeIlEx2m.8fTzmkbdd6wt2if6y9LE/GUy.AhMnce', 'admin@cecoi.com', '123456789','123456789', 'super admin', 'Masculino', '2019-05-05');

INSERT INTO PERMISSAO VALUES (1,'ROLE_ADMIN'), (2,'ROLE_EDITOR');

INSERT INTO USUARIO_PERMISSAO VALUES (1, 1);

INSERT INTO TURMA VALUES (1, 'Matutino', 'Matutino 1');
INSERT INTO TURMA VALUES (2, 'Matutino', 'Vespertino 2');
INSERT INTO TURMA VALUES (3, 'Matutino', 'Noturno 3');
INSERT INTO TURMA VALUES (4, 'Vespertino', 'Matutino 4');
INSERT INTO TURMA VALUES (5, 'Vespertino', 'Vespertino 5');
INSERT INTO TURMA VALUES (6, 'Vespertino', 'Noturno 6');
INSERT INTO TURMA VALUES (7, 'Noturno', 'Matutino 7');
INSERT INTO TURMA VALUES (8, 'Noturno', 'Vespertino 8');
INSERT INTO TURMA VALUES (9, 'Noturno', 'Noturno 9');
INSERT INTO TURMA VALUES (10, 'Matutino', 'Matutino 10');
INSERT INTO TURMA VALUES (11, 'Matutino', 'Vespertino 11');
INSERT INTO TURMA VALUES (12, 'Matutino', 'Noturno 12');
INSERT INTO TURMA VALUES (13, 'Vespertino', 'Matutino 13');
INSERT INTO TURMA VALUES (14, 'Vespertino', 'Vespertino 14');
INSERT INTO TURMA VALUES (15, 'Vespertino', 'Noturno 15');
INSERT INTO TURMA VALUES (16, 'Noturno', 'Matutino 16');
INSERT INTO TURMA VALUES (17, 'Noturno', 'Vespertino 17');
INSERT INTO TURMA VALUES (18, 'Noturno', 'Noturno 18');
INSERT INTO TURMA VALUES (19, 'Matutino', 'Matutino 19');
INSERT INTO TURMA VALUES (20, 'Matutino', 'Vespertino 20');
INSERT INTO TURMA VALUES (21, 'Matutino', 'Noturno 21');
INSERT INTO TURMA VALUES (22, 'Vespertino', 'Matutino 22');
INSERT INTO TURMA VALUES (23, 'Vespertino', 'Vespertino 23');
INSERT INTO TURMA VALUES (24, 'Vespertino', 'Noturno 24');
INSERT INTO TURMA VALUES (25, 'Noturno', 'Matutino 25');
INSERT INTO TURMA VALUES (26, 'Noturno', 'Vespertino 26');
INSERT INTO TURMA VALUES (27, 'Noturno', 'Noturno 27');
INSERT INTO TURMA VALUES (28, 'Matutino', 'Matutino 28');
INSERT INTO TURMA VALUES (29, 'Matutino', 'Vespertino 29');
INSERT INTO TURMA VALUES (30, 'Matutino', 'Noturno 30');
INSERT INTO TURMA VALUES (31, 'Vespertino', 'Matutino 31');
INSERT INTO TURMA VALUES (32, 'Vespertino', 'Vespertino 32');
INSERT INTO TURMA VALUES (33, 'Vespertino', 'Noturno 33');
INSERT INTO TURMA VALUES (34, 'Noturno', 'Matutino 34');
INSERT INTO TURMA VALUES (35, 'Noturno', 'Vespertino 35');
INSERT INTO TURMA VALUES (36, 'Noturno', 'Noturno 36');
INSERT INTO TURMA VALUES (37, 'Matutino', 'Matutino 37');
INSERT INTO TURMA VALUES (38, 'Matutino', 'Vespertino 38');
INSERT INTO TURMA VALUES (39, 'Matutino', 'Noturno 39');
INSERT INTO TURMA VALUES (40, 'Vespertino', 'Matutino 40');
INSERT INTO TURMA VALUES (41, 'Vespertino', 'Vespertino 41');
INSERT INTO TURMA VALUES (42, 'Vespertino', 'Noturno 42');
INSERT INTO TURMA VALUES (43, 'Noturno', 'Matutino 43');
INSERT INTO TURMA VALUES (44, 'Noturno', 'Vespertino 44');
INSERT INTO TURMA VALUES (45, 'Noturno', 'Noturno 45');
INSERT INTO TURMA VALUES (46, 'Matutino', 'Matutino 46');
INSERT INTO TURMA VALUES (47, 'Matutino', 'Vespertino 47');
INSERT INTO TURMA VALUES (48, 'Matutino', 'Noturno 48');
INSERT INTO TURMA VALUES (49, 'Vespertino', 'Matutino 49');
INSERT INTO TURMA VALUES (50, 'Vespertino', 'Vespertino 50');
INSERT INTO TURMA VALUES (51, 'Vespertino', 'Noturno 51');
INSERT INTO TURMA VALUES (52, 'Noturno', 'Matutino 52');
INSERT INTO TURMA VALUES (53, 'Noturno', 'Vespertino 53');
INSERT INTO TURMA VALUES (54, 'Noturno', 'Noturno 54');

INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 1', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 2', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 3', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 4', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 5', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 6', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 7', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 8', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 9', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 10', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 11', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 12', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 13', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 14', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 15', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 16', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 17', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 18', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 19', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 20', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 21', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 22', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 23', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 24', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 25', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 26', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 27', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 28', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 29', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 30', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 31', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 32', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 33', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 34', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 35', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 36', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 37', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 38', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 39', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 40', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 41', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 42', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 43', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 44', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 45', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 46', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 47', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 48', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL 49', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');


INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (1, 1, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (2, 2, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (3, 3, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (4, 4, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (5, 5, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (6, 6, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (7, 7, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (8, 8, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (9, 9, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (10, 10, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (11, 11, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (12, 12, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (13, 13, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (14, 14, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (15, 15, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (16, 16, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (17, 17, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (18, 18, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (19, 19, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (20, 20, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (21, 21, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (22, 22, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (23, 23, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (24, 24, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (25, 25, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (26, 26, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (27, 27, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (28, 28, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (29, 29, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (30, 30, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (31, 31, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (32, 32, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (33, 33, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (34, 34, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (35, 35, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (36, 36, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (37, 37, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (38, 38, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (39, 39, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (40, 40, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (41, 41, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (42, 42, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (43, 43, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (44, 44, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (45, 45, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (46, 46, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (47, 47, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (48, 48, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES (49, 49, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);


commit;
