package aula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestesAssertEquals {

	public void carlos() {
		
	}

	@Test
	public void test1() {
		/*
		 * Parâmetros: mensagem, valor esperado, operação, delta Não apresenta falha,
		 * pois será testado o intervalo 3.5 < (2.1 + 2.1) < 4.5
		 */
		assertEquals("Msg test1", 4, 2.1 + 2.1, 0.5);
	}

	@Test
	public void test2() {
		/*
		 * Apresenta falha, pois será testado o intervalo 4 < (2.1 + 2.1) < 4
		 */
		assertEquals("Msg test2", 4, 2.1 + 2.1, 0);
	}

	@Test
	public void test3() {
		/*
		 * Parâmetros: mensagem, valor esperado, operação Apresenta falha, pois será
		 * testado 4 == (3 + 3)
		 */
		assertEquals("Msg test3", 4, 3 + 3);
	}

	@Test
	public void test4() {
		/*
		 * Parâmetros: valor esperado, operação, delta Não apresenta falha, pois será
		 * testado 3.5 < (2 + 2) < 4.5
		 */
		assertEquals(4, 2 + 2, 0.5);
	}

	@Test
	public void test5() {
		/*
		 * Parâmetros: valor esperado, operação Apresenta falha, pois será testado 4 ==
		 * (3 + 3)
		 */
		assertEquals(4, 3 + 3);
	}
}
