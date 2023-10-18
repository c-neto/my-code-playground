package aula;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MTest {

	private A a;
	private int ent;
	private boolean esp;
	
	public MTest(int ent, boolean esp) {
		this.ent = ent;
		this.esp = esp;
	}

	@Before
	public void setUp() {
		a = new A();
	}

	@Parameters
	public static Collection<Object[]> get() {
		Object[][] v = new Object[][] { {-10, true}, 
										{ -9, true}, 
										{  0, true}, 
										{  9, true},
										{ 11, false}};
		return Arrays.asList(v);
	}

	@Ignore
	@Test
	public void test() {
		assertEquals(false, a.m(-10));
		assertEquals(true, a.m(0));
		assertEquals(true, a.m(9));
	}
	
	@Test
	public void y() {
		assertEquals(esp, a.m(ent));
	}

}
