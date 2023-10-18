package aula;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class Ex4Test1 {
	
	Operacao op;

	@Before
	public void setUp() {
		op = new Operacao();
	}
	
	@Test(timeout=1100)
	public void test() throws InterruptedException {
		assertNotNull(op.timer(1));
	}

}
