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

INSERT INTO ENDERECO (end_rua, end_numero, end_bairro, end_cep, end_cidade, end_edr_uf, end_usr_fk) VALUES ("rua strings",12,"bairro strings","12345-678","cidade strings", "st", 1);

INSERT INTO TELEFONE (tel_tipo, tel_numero, tel_usr_fk) VALUES ('Movel', "12 99999-9999", 1);

INSERT INTO PERMISSAO VALUES (1,'ROLE_ADMIN'), (2,'ROLE_EDITOR'), (3,'ROLE_VIEWER');

INSERT INTO USUARIO_PERMISSAO VALUES (1, 1);

