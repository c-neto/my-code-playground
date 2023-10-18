package br.org.celiolemos.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlunoRepositoryTeste.class, DoencaRepositoryTeste.class, ResponsavelRepositoryTeste.class,
		TelefoneRepositoryTeste.class, TurmaRepositoryTeste.class, UsuarioRepositoryTeste.class,
		EnderecoRepositoryTeste.class })
public class RepositoriesTeste {
}
