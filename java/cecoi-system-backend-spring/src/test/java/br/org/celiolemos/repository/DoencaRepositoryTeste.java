package br.org.celiolemos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Sets;

import br.org.celiolemos.model.Aluno;
import br.org.celiolemos.model.Doenca;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.model.Turma.Periodo;
import br.org.celiolemos.model.enumerator.Sexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoencaRepositoryTeste {

	@Autowired
	private DoencaRepository doencaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;
	private Turma turma;
	private Aluno aluno;
	private Doenca doenca;
	private Responsavel responsavel;

	@Before
	public void setUp() {
		turma = new Turma(Periodo.Vespertino, "T5019A");
		aluno = new Aluno("Aluno teste", Sexo.Masculino, "Branco", new Date(), 3);
		doenca = new Doenca(aluno, "Doença teste", "Testando a inserção de doenças");
		responsavel = new Responsavel(Sets.newHashSet(aluno), "111111", "66666", "IResponsavel", "Irmã", Sexo.Feminino, new Date(),
				"mau", "mau@ricio.com");
	}

	@Test
	public void inserindoDadosEExcluindo() {
		Turma t = turmaRepository.save(turma);
		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		aluno.setTurma(t);
		Aluno a = alunoRepository.save(aluno);
		Doenca d = doencaRepository.save(doenca);

		Optional<Doenca> doencaDoBanco = doencaRepository.findById(d.getId());

		assertTrue(doencaDoBanco.isPresent());
		assertNotNull(doencaDoBanco.get());

		doencaRepository.deleteById(d.getId());
		alunoRepository.deleteById(a.getId());
		turmaRepository.delete(t);
	}
}
