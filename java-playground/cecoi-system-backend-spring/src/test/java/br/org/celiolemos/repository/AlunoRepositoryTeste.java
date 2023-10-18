package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Sets;

import br.org.celiolemos.model.Aluno;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.model.Turma.Periodo;
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoRepositoryTeste {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private ResponsavelRepository responsavelRepository;
	private Aluno aluno;
	private Turma turma;
	private Responsavel responsavel;


	@Before
	public void setUp() {
		turma = new Turma(Periodo.Noturno, "T9019A");
		aluno = new Aluno("Aluno teste", Sexo.Masculino, "Branco", new Date(), 3);
		turma = new Turma(Periodo.Matutino, "TA2019");
		responsavel = new Responsavel(Sets.newHashSet(aluno), "rg", "cpf", "nome", "0", Sexo.Feminino, new Date(),
				"profissao", "email");
	}

	@After
	public void tearDown() {
		aluno = null;
		responsavel = null;
		turma = null;
	}

	@Test
	public void inserindoDadosEExluido() {

		Turma t = turmaRepository.save(turma);
		aluno.setTurma(t);
		Responsavel responsavelCriado = responsavelRepository.save(responsavel);
		aluno.setResponsavel(responsavelCriado);
		Aluno a = alunoRepository.save(aluno);

		Optional<Aluno> alunoDoBanco = alunoRepository.findById(a.getId());

		assertTrue(alunoDoBanco.isPresent());
		assertNotNull(alunoDoBanco.get());
		
		alunoRepository.deleteById(a.getId());
		assertTrue(turmaRepository.findById(t.getId()).isPresent());
		turmaRepository.delete(t);
	}
}
