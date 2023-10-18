package aula;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestesArrayEquals {

	@Test
	public void test1() {
		String[] a = { "um", "dois" }, b = { "três", "quatro" };
		assertArrayEquals("Msg test1", a, b);
	}

	@Test
	public void test2() {
		String[] a = { "um", "dois" }, b = { "um", "dois" };
		assertArrayEquals(a, b);
	}
}
