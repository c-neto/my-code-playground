INSERT_PESSOAS = """
INSERT INTO TURMA VALUES ({}, {}, {});
""".strip()

INSERT_RESPONSAVEL = """
INSERT INTO RESPONSAVEL (res_rg, res_cpf, res_nome, res_grau_parentesco, res_sexo, res_data_nascimento, res_profissao, res_email) VALUES ('12345', '12345','RESPONSAVEL {}', 'TIA', 'Feminino', '2019-01-19', 'Profissão', 'e-mail');
""".strip()

INSERT_ALUNO = """
INSERT INTO ALUNO (alu_res_fk, alu_trm_fk, alu_nome, alu_sexo, alu_cor, alu_data_nascimento, alu_numero_irmaos) VALUES ({}, {}, 'Felipe Menino', 'Masculino', 'branco', '1999-01-01', 2);
""".strip()

INSERT_USUARIO = 'INSERT INTO USUARIO ( usr_login, usr_senha, usr_email, usr_rg, usr_cpf, usr_nome, usr_sexo, usr_data_nascimento ) VALUES ( "login", "123", "email@mail.com", "123123123", "12313213", "sem nome", "Feminino", "2019-11-5" );'

DIAS = ["'Matutino'", "'Vespertino'", "'Noturno'"]
TEMPLATES = ["'Matutino {}'", "'Vespertino {}'", "'Noturno {}'"]

m = 1
c = 0
with open("inserts_turma.sql", "w") as f:
    while m < 50:
        for dia in DIAS:
            for t in TEMPLATES:
                f.write(INSERT_PESSOAS.format(
                    str(m), dia, t.format(str(m))
                ) + "\n")
                m += 1

m = 1
c = 1
with open("inserts_responsavel.sql", "w") as f:
    while m < 50:
        f.write(INSERT_RESPONSAVEL.format(
            str(m)    
        ) + "\n")
        m += 1

m = 1
with open("inserts_aluno.sql", "w") as f:
    while m < 50:
        f.write(INSERT_ALUNO.format(
            str(m), str(m)    
        ) + "\n")
        m += 1


