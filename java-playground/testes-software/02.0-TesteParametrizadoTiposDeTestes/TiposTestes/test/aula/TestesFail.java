package aula;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesFail {

	@Test
	public void test1() {
		System.out.println("Método test1: antes");
		fail("Faz o test1 falhar");
		System.out.println("Método test1: após");
	}

	@Test
	public void test2() {
		System.out.println("Método test2: antes");
		fail();
		System.out.println("Método test2: após");
	}

}