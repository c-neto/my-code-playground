package aula;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestesTimeout {

	private Operacao op;

	@Before
	public void setUp() {
		/* chamado antes de cada @Test */
		op = new Operacao();
	}

	@Test(timeout = 1000)
	public void test1() {
		/* Este teste falha porque ele dura mais de 1 seg. */
		assertEquals("Msg test1", 1, op.loopInfinito());
	}

	@Test(timeout = 4000)
	public void test2() {
		/* Este teste não falha porque ele NÃO dura mais de 4 seg. */
		assertEquals("Msg test2", 1, op.loopInfinito());
	}

}
