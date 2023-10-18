package aula;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ATest {

	@Mock
	private A a = null;

	@Before
	public void setUp() throws NullPointerException, Exception {
		a = mock(A.class);
		when(a.area(2)).thenCallRealMethod();
	}

	@Test
	public void test1() throws NullPointerException, Exception {
		assertEquals(0, a.area(2),0);
		verify(a, times(1)).pi();
	}
}
