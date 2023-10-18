package aula;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class RuleTimeoutTest {

	@Rule
	public TestRule tr = Timeout.millis(40);
	@Rule
	public TestName tn = new TestName();

	@Test
	public void test1() {
		while (true)
			;
	}

	@Test
	public void test2() {
		while (!false);
	}

	@Test
	public void test3() {
		assertEquals("test3", tn.getMethodName());
	}
}
