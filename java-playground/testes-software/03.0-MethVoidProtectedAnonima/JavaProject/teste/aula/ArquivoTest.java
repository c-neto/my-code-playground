package aula;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class ArquivoTest {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	/*
	 * o método none retorna uma Rule que não espera exceções, semelhantemente ao
	 * comportamento do teste sem esta regra
	 */	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test1() throws IOException {
		/* cria um arquivo temporário de nome teste.txt */
		File arquivo = folder.newFile("teste.txt");
		/* imprime o local onde o arquivo foi criado */
		System.out.println(folder.getRoot());
		/* escrever no arquivo */
		Arquivo.escrever(arquivo, "Bom dia");
		Arquivo.escrever(arquivo, "Boa tarde");
		/* ler o arquivo */
		Arquivo.imprimir(arquivo);
		/* verifica se o arquivo existe */
		assertTrue(arquivo.exists());
	}

	@Test
	public void test2() throws IOException {
		/* cria uma pasta temporária de nome teste */
		File pasta = folder.newFolder("teste");
		System.out.println(folder.getRoot());
		assertTrue(pasta.exists());
	}

	@Test
	public void test3() {
		/*
		 * acrescenta à lista de requisitos a exceção a ser esperada
		 */
		thrown.expect(IOException.class);
		/* fornece uma mensagem para a exceção */
		thrown.expectMessage("Exceção no test3");

	}

	@Test
	public void test4() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Exceção no test4");
	}
}