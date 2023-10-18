package aula;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesAssertNullNotNull {

	@Test
	public void test1() {
		Object obj = null;
		/* Parâmetros: mensagem, condição */
		assertNull("Msg test1", obj);
	}

	@Test
	public void test2() {
		Object obj = new Object();
		/* Parâmetro: condição */
		assertNull(obj);
	}

	@Test
	public void test3() {
		Object obj = null;
		/* Parâmetros: mensagem, condição */
		assertNotNull("Msg test3", obj);
	}

	@Test
	public void test4() {
		Object obj = new Object();
		/* Parâmetro: condição */
		assertNotNull(obj);
	}
}
