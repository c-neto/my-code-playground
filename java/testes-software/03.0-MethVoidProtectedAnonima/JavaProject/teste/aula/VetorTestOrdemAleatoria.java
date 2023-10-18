package aula;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.DEFAULT)
public class VetorTestOrdemAleatoria {

	@Test
	public void test4() {
		Vetor.add(12);
		assertTrue(Vetor.existe(12));
	}

	@Test
	public void test3() {
		Vetor.add("10");
		assertTrue(Vetor.existe("10"));
	}

	@Test
	public void test1() {
		Vetor.add(true);
		assertTrue(Vetor.existe(true));
	}

	@Test
	public void test2() {
		Vetor.add(2.5);
		assertTrue(Vetor.existe(2.5));
	}
}
