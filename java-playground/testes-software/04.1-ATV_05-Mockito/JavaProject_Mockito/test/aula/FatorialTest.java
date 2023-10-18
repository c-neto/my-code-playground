package aula;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FatorialTest {

    @Mock
    private A a;

    private long entrada;
    private long esperado;

    public FatorialTest(long entrada, long esperado){
        this.entrada = entrada;
        this.esperado = esperado;
    }

    @Before
    public void setUp(){
        a = mock(A.class);
        when(a.fatorial(0)).thenReturn((long) 0);
        when(a.fatorial(1)).thenReturn((long) 1);
        when(a.fatorial(2)).thenReturn((long) 2);
        when(a.fatorial(5)).thenReturn((long) 120);

    }

    @Parameterized.Parameters
    public static List<Object[]> get() {
        Object[][] v = new Object[][] {{0, 0,},
                                       {1, 1},
                                       {2, 2},
                                       {5, 120}
        };
        return Arrays.asList(v);
    }

    @Test
    public void fatoral(){
        assertEquals(esperado, a.fatorial(entrada), 0);
    }

}