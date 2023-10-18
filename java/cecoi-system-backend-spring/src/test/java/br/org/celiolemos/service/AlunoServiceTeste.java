package br.org.celiolemos.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Sets;

import br.org.celiolemos.api.service.AlunoService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.model.Aluno;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.model.Turma;
import br.org.celiolemos.model.Turma.Periodo;
import br.org.celiolemos.model.enumerator.Sexo;
import br.org.celiolemos.repository.ResponsavelRepository;
import br.org.celiolemos.repository.TurmaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class AlunoServiceTeste {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;
	private Aluno aluno;
	private Turma turma;
	private Responsavel responsavel;
	private Endereco endereco;
	private Telefone telefone;

	@Before
	public void setUp() {
		aluno = new Aluno("Aluno teste", Sexo.Masculino, "Preto", new Date(), 3);
		turma = new Turma(Periodo.Matutino, "TD2019");
		telefone = new Telefone(Telefone.Tipo.Movel, "123");
		endereco = new Endereco("rua", 1, "complemento", "bairro", "cidade", "cep", "uf");
		responsavel = new Responsavel("111111", "77777", "IResponsavel", "Irmã", Sexo.Feminino, new Date(), "mau",
				"mau@ricio.com", Sets.newHashSet(aluno), Sets.newHashSet(telefone), Sets.newHashSet(endereco));
		aluno.setResponsavel(responsavel);
	}

	@After
	public void tearDown() {
		aluno = null;
		turma = null;
		responsavel = null;
		endereco = null;
		telefone = null;
	}

	@Test(expected = ElementoJaCadastrado.class)
	@WithMockUser(roles = "ADMIN")
	public void testeAdicaoAluno() {
		turma = turmaRepository.save(turma);
		alunoService.adicionarAluno(aluno, turma.getId());
		alunoService.adicionarAluno(aluno, turma.getId());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testeAdicaoAlunoCompleto() {
		turma = turmaRepository.save(turma);
		aluno.setTurma(turma);
		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setResponsavel(r);
		
		Aluno alunoCadastrado = alunoService.adicionarAluno(aluno, turma.getId());
		
		assertNotNull(alunoCadastrado);
		alunoService.removeAluno(alunoCadastrado.getId());
	}

	@Test
	@WithMockUser(roles = "ADMIN")
	public void testeEncontraUsuarioPorId() {

		turma = turmaRepository.save(turma);
		Responsavel r = responsavelRepository.save(responsavel);
		aluno.setTurma(turma);
		aluno.setResponsavel(r);
		aluno = alunoService.adicionarAluno(aluno, turma.getId());

		Aluno alunoBuscado = alunoService.encontrarPorId(aluno.getId());
		assertNotNull(alunoBuscado);

		alunoService.removeAluno(aluno.getId());
	}

	@Test
	public void testeAtualizaUsuario() {
		turma = turmaRepository.save(turma);
		aluno.setTurma(turma);
	}
}
