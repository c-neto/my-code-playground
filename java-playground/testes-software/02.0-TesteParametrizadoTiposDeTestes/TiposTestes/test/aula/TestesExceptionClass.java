package aula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestesExceptionClass {

	private Operacao op = new Operacao();

	@Test
	public void test3() {
		/*
		 * Este teste falha porque o método retorna uma exceção e o teste espera um
		 * valor numérico
		 */
		assertEquals(1.25, op.divisao(5, 0), 0);
	}
	//@Test(expected = Exception.class) //pode ser esse tbm... 
	@Test(expected = ArithmeticException.class)
	public void test4() {
		/*
		 * Este teste não falha porque o método lança ArithmeticException
		 */
		assertEquals(1.25, op.divisao(5, 0), 0);
	}

	@Test(expected = Exception.class)
	public void test5() {
		// Exception e = new ArithmeticException(); isso é permitido, pq Ela herda de
		// Exception

		/*
		 * Este teste não falha porque Exception é um super tipo para
		 * ArithmeticException
		 */
		assertEquals(1.25, op.divisao(5, 0), 0);
	}

	@Test(expected = Exception.class )
	public void test6() {
		/* Este teste falha porque NÃO lança Exception */
		assertEquals(1.25, op.divisao(5, 4), 0);
	}

}
