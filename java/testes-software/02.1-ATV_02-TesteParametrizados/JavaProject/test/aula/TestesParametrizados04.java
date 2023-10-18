package aula;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;;

@RunWith(Parameterized.class)
public class TestesParametrizados04 {

	private Operacao op;
	private int tempoLimite;
	private int cont;
	
	public TestesParametrizados04(int cont, int tempoLimite) {
		this.tempoLimite = tempoLimite;
		this.cont = cont;
	}
	
	@Before
	public void setUp() {
		op = new Operacao();
	}

	@After
	public void tearDown() {
		op = null;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parametros() {

		Object[][] v = new Object[][] {
			{1, 1100 }, // green
			{3, 3100 }  // red
		};

		return Arrays.asList(v);
	}

	
	@Test(timeout = 1100)
	public void test1() throws InterruptedException {
		assertEquals("Msg test1", 1, op.timer(cont));
	}
	
	
}