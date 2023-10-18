package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurmaRepositoryTeste {

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;

	private Turma turma;
	private Responsavel responsavel;

	@Before
	public void setUp() {
		turma = new Turma(Turma.Periodo.Matutino, "TA2019");
		responsavel = new Responsavel(null, "111111", "222222", "IResponsavel", "Irmã", Sexo.Feminino, new Date(),
				"mau", "mau@ricio.com");
	}

	@After
	public void tearDown() {
		turma = null;
		responsavel = null;
	}

	@Test
	public void inserindoDadosEExluido() {
		Turma t = turmaRepository.save(turma);
		Optional<Turma> turmaDoBanco = turmaRepository.findById(t.getId());

		assertTrue(turmaDoBanco.isPresent());
		assertNotNull(turmaDoBanco.get());

		turmaRepository.deleteById(t.getId());
	}

	/**
	 * Este método de teste precisou ser anotado com @Transactional por conta da
	 * operação 1 para muitos, e com @Rollback(false) para permitir que os
	 * resultados do teste fossem salvos no banco (Isto vai contra o @Transactional,
	 * porém sendo um método de teste, foi feito desta forma)
	 */
	@Test
	@Transactional
	public void inserindoDoisAlunos() {

		Aluno a = new Aluno("aluno teste", Sexo.Feminino, "amarelo", new Date(), 0);
		Aluno a2 = new Aluno("aluno teste 2", Sexo.Masculino, "preto", new Date(), 2);
		responsavel.setAlunos(Sets.newHashSet(a, a2));
		Turma t = turmaRepository.save(turma);
		a.setTurma(t);
		a2.setTurma(t);

		t = turmaRepository.findById(t.getId()).get();
		if (Objects.isNull(t.getAlunos())) {
			t.setAlunos(new HashSet<>());
			t.getAlunos().add(a);
		}
		responsavelRepository.save(responsavel);
		a.setResponsavel(responsavel);
		a2.setResponsavel(responsavel);
		alunoRepository.save(a);
		t = turmaRepository.findById(t.getId()).get();
		if (Objects.nonNull(t.getAlunos())) {
			t.getAlunos().add(a2);
			alunoRepository.save(a2);
		}

		t = turmaRepository.findById(t.getId()).get();

		assertNotNull(t.getAlunos());
		assertTrue(t.getAlunos().size() >= 2);

		alunoRepository.deleteById(a.getId());
		alunoRepository.deleteById(a2.getId());
		turmaRepository.deleteById(t.getId());
	}
}
