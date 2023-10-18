package aula;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Ex4Test2 {

	Operacao op;

	@Before
	public void setUp() {
		op = new Operacao();
	}

	@Test(timeout = 3100)
	public void test2() throws InterruptedException {
		assertNotNull(op.timer(3));
	}
}
