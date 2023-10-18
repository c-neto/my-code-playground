package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

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
@Transactional
public class ResponsavelRepositoryTeste {

	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	private Aluno aluno;
	private Turma turma;
	private Responsavel responsavel;

	@Before
	public void setUp() {

		turma = new Turma(Periodo.Matutino, "T2020B");
		aluno = new Aluno("Aluno Teste", Sexo.Feminino, "Preto", new Date(), 3);
		responsavel = new Responsavel(Sets.newHashSet(aluno), "111111", "44444", "IResponsavel", "Irmã", Sexo.Feminino, new Date(),
				"mau", "mau@ricio.com");

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

		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		alunoRepository.save(aluno);

		Optional<Responsavel> responsavelDoBanco = responsavelRepository.findById(r.getId());

		assertTrue(responsavelDoBanco.isPresent());
		assertNotNull(responsavelDoBanco.get());

		alunoRepository.delete(aluno);
		responsavelRepository.deleteById(r.getId());
		turmaRepository.delete(t);
	}

	@Test
	public void buscandoPorCpf() {
		Turma t = turmaRepository.save(turma);
		aluno.setTurma(t);

		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		alunoRepository.save(aluno);

		assertTrue(responsavelRepository.existsByCpf(r.getCpf()));

		alunoRepository.delete(aluno);
		responsavelRepository.deleteById(r.getId());
		turmaRepository.delete(t);
	}

	@Test
	public void buscandoPorRg() {
		Turma t = turmaRepository.save(turma);
		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setTurma(t);
		aluno.setResponsavel(r);
		alunoRepository.save(aluno);

		assertTrue(responsavelRepository.existsByRg(r.getRg()));

		alunoRepository.delete(aluno);
		responsavelRepository.deleteById(r.getId());
		turmaRepository.delete(t);
	}
}
