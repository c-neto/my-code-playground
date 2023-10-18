package aula;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestesAnnotations {

	@BeforeClass
	public static void inicio() {
		System.out.println("Método inicio");
	}

	@AfterClass
	public static void fim() {
		System.out.println("Método fim");
	}

	@Before
	public void antes() {
		System.out.println("Método antes");
	}

	@After
	public void depois() {
		System.out.println("Método depois");
	}

	@Test
	public void test1() {
		System.out.println("Método test1");
	}

	@Ignore
	@Test
	public void test2() {
		System.out.println("Método test2");
	}

	@Test
	public void test3() {
		System.out.println("Método test3");
	}
}
