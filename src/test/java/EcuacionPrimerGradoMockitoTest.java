import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;



public class EcuacionPrimerGradoMockitoTest {



    @InjectMocks

    private EcuacionPrimerGrado ecuacionPrimerGrado;



    @Mock

    private Parseador parseador;



    @BeforeEach

    public void inicializaMocks() {

        MockitoAnnotations.openMocks(this);

    }



    @Test

    public void solucionaEcuacionConMenos() throws Exception {

        String ecuacion = "2x - 1 = 0";

        when(parseador.obtenerParte1(ecuacion)).thenReturn(2.0);

        when(parseador.obtenerParte2(ecuacion)).thenReturn(-1.0);

        when(parseador.obtenerParte3(ecuacion)).thenReturn(0.0);



        double result = ecuacionPrimerGrado.obtenerResultado(ecuacion);

        double valueExpected = 0.5;

        assertEquals(valueExpected, result, 0.0001); // Permite una pequeña diferencia en los valores de punto flotante

    }



    @Test

    public void testObtenerResultadoExcepcion() {

        String ecuacion = "0x + 1 = 0"; // Un caso que debe lanzar una excepción

        when(parseador.obtenerParte1(ecuacion)).thenReturn(0.0);

        when(parseador.obtenerParte2(ecuacion)).thenReturn(1.0);

        when(parseador.obtenerParte3(ecuacion)).thenReturn(0.0);



        Exception exception = assertThrows(Exception.class, () -> {

            ecuacionPrimerGrado.obtenerResultado(ecuacion);

        });



        String expectedMessage = "La ecuación no tiene solución.";

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



    @Test

    public void testObtenerResultadoConInfinitasSoluciones() {

        String ecuacion = "0x + 0 = 0"; // Un caso que debe lanzar una excepción de infinitas soluciones

        when(parseador.obtenerParte1(ecuacion)).thenReturn(0.0);

        when(parseador.obtenerParte2(ecuacion)).thenReturn(0.0);

        when(parseador.obtenerParte3(ecuacion)).thenReturn(0.0);



        Exception exception = assertThrows(Exception.class, () -> {

            ecuacionPrimerGrado.obtenerResultado(ecuacion);

        });



        String expectedMessage = "La ecuación tiene infinitas soluciones.";

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



    /**

     * Prueba una ecuación con coeficiente decimal y verifica la interacción con el mock.

     * Ecuación: 0.5x - 1 = 0

     * Se espera que el resultado sea 2.0.

     */

    @Test

    public void solucionaEcuacionConCoeficienteDecimal() throws Exception {

        String ecuacion = "0.5x - 1 = 0";

        when(parseador.obtenerParte1(ecuacion)).thenReturn(0.5);

        when(parseador.obtenerParte2(ecuacion)).thenReturn(-1.0);

        when(parseador.obtenerParte3(ecuacion)).thenReturn(0.0);



        double result = ecuacionPrimerGrado.obtenerResultado(ecuacion);

        double valueExpected = 2.0; // Resultado esperado

        assertEquals(valueExpected, result, 0.0001); // Permite una pequeña diferencia en los valores de punto flotante



        // Verifica que se haya llamado a los métodos del mock

        verify(parseador).obtenerParte1(ecuacion);

        verify(parseador).obtenerParte2(ecuacion);

        verify(parseador).obtenerParte3(ecuacion);

    }



    /**

     * Prueba una ecuación con parte3 decimal.

     * Ecuación: 3x + 4 = 5.5

     * Se espera que el resultado sea 0.5

     */

    @Test

    public void solucionaEcuacionConParte3Decimal() throws Exception {

        String ecuacion = "3x + 4 = 5.5";

        when(parseador.obtenerParte1(ecuacion)).thenReturn(3.0);

        when(parseador.obtenerParte2(ecuacion)).thenReturn(4.0);

        when(parseador.obtenerParte3(ecuacion)).thenReturn(5.5);



        double result = ecuacionPrimerGrado.obtenerResultado(ecuacion);

        double valueExpected = 0.5; // Resultado esperado

        assertEquals(valueExpected, result, 0.0001); // Permite una pequeña diferencia en los valores de punto flotante



        // Verifica que se haya llamado a los métodos del mock

        verify(parseador).obtenerParte1(ecuacion);

        verify(parseador).obtenerParte2(ecuacion);

        verify(parseador).obtenerParte3(ecuacion);

    }

}

