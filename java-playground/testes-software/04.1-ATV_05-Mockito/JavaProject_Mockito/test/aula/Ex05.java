package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class Ex05 {

	@Mock
	private A a = null;

	@Before
	public void setUp() throws NullPointerException, Exception {
		a = mock(A.class);
	}

	@Test(expected=Exception.class)
	public void incTest() {
		when(a.inc()).thenReturn(1, 2, 3, 4).thenThrow(new NullPointerException("Além do limite"));
		while (true) {
			System.out.println(a.inc());
		}
	}
}