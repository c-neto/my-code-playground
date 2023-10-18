package aula;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesAssertSameNotSame {

	@Test
	public void test1() {
		String a = null, b = null;
		/* Parâmetros: mensagem, objeto, objeto */
		assertSame("Msg test1", a, b);
	}

	@Test
	public void test2() {
		String a = "oi", b = "oi";
		/* Parâmetros: objeto, objeto */
		assertSame(a, b);
	}

	@Test
	public void test3() {
		Object a = new Object(), b = new Object();
		assertSame(a, b);
	}

	@Test
	public void test4() {
		String a = null, b = null;
		/* Parâmetros: mensagem, objeto, objeto */
		assertNotSame("Msg test4", a, b);
	}

	@Test
	public void test5() {
		String a = "oi", b = "oi";
		/* Parâmetros: condição */
		assertNotSame(a, b);
	}

	@Test
	public void test6() {
		Object a = new Object(), b = new Object();
		assertNotSame(a, b);
	}
}
