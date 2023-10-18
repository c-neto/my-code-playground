package aula;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestesAssertTrueFalse {
	@Test
	public void test1() {
		/*
		 * Parâmetros: mensagem, condição Apresenta falha, pois será testado (8 < 5) ==
		 * true
		 */
		assertTrue("Msg test1", 8 < 5);
	}

	@Test
	public void test2() {
		/*
		 * Parâmetros: condição Não apresenta falha, pois será testado (8 != 5) == true
		 */
		assertTrue(8 != 5);
	}

	@Test
	public void test3() {
		/*
		 * Parâmetros: mensagem, condição Não apresenta falha, pois será testado (8 < 5)
		 * == false
		 */
		assertFalse("Msg test3", 8 < 5);
	}

	@Test
	public void test4() {
		/*
		 * Parâmetros: condição Apresenta falha, pois será testado (8 != 5) == false
		 */
		assertFalse(8 != 5);
	}
}
