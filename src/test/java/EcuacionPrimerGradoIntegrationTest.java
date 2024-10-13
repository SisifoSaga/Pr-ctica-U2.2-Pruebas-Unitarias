import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; 
import org.junit.jupiter.api.Test;

public class EcuacionPrimerGradoIntegrationTest {
    EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();
    @Test
    public void solucionaEcuacionConMenos() throws Exception {
        Double result = ecuacion.obtenerResultado("2x - 1 = 0");
        Double valueExpected = 0.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }
    @Test
    public void solucionaEcuacionConMas() throws Exception {
        Double result = ecuacion.obtenerResultado("2x + 1 = 0");
        Double valueExpected = -0.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }
 @Test
    public void solucionaEcuacionConParte3Mayor0() throws Exception {
        Double result = ecuacion.obtenerResultado("2x + 1 = 10");
        Double valueExpected = 4.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }

    /**
     * Prueba la solución de una ecuación donde parte3 es menor que cero.
     * Ecuación: 2x + 1 = -10
     * Se espera que el resultado sea -5.5
     */
    @Test
    public void solucionaEcuacionConParte3Menor0() throws Exception {
        Double result = ecuacion.obtenerResultado("2x + 1 = -10");
        Double valueExpected = -5.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }

    /**
     * Prueba la solución de una ecuación con coeficiente decimal.
     * Ecuación: 0.5x + 1 = 0
     * Se espera que el resultado sea -2.0
     */
    @Test
    public void solucionaEcuacionConCoeficienteDecimal() throws Exception {
        Double result = ecuacion.obtenerResultado("0.5x + 1 = 0");
        Double valueExpected = -2.0; // Resultado esperado
        assertEquals(valueExpected, result);
    }

    /**
     * Prueba la solución de una ecuación sin solución (coeficiente de x es 0 y parte2 != parte3).
     * Ecuación: 0x + 1 = 0
     * Se espera que lance una excepción indicando que no hay solución.
     */
    @Test
    public void ecuacionSinSolucion() {
        Exception exception = assertThrows(Exception.class, () -> {
            ecuacion.obtenerResultado("0x + 1 = 0");
        });

        String expectedMessage = "La ecuación no tiene solución.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Prueba una ecuación con infinitas soluciones (coeficiente de x es 0 y parte2 == parte3).
     * Ecuación: 0x + 1 = 1
     * Se espera que lance una excepción indicando infinitas soluciones.
     */
    @Test
    public void ecuacionInfinitasSoluciones() {
        Exception exception = assertThrows(Exception.class, () -> {
            ecuacion.obtenerResultado("0x + 1 = 1");
        });

        String expectedMessage = "La ecuación tiene infinitas soluciones.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * Prueba una ecuación que debería tener infinitas soluciones.
     * Ecuación: 0x + 2 = 2
     * Se espera que lance una excepción indicando infinitas soluciones.
     */
    @Test
    public void ecuacionInfinitasSoluciones2() {
        Exception exception = assertThrows(Exception.class, () -> {
            ecuacion.obtenerResultado("0x + 2 = 2");
        });

        // Mensaje esperado incorrecto para demostrar un fallo en el test.
        String expectedMessage = "La ecuación no tiene solución."; // Incorrecto, debería ser infinitas soluciones
        String actualMessage = exception.getMessage();

        // Este assert fallará porque el mensaje es diferente
        assertEquals(expectedMessage, actualMessage);
    }


    /**
     * Prueba una ecuación con parte3 negativa y coeficiente decimal.
     * Ecuación: 0.2x - 0.5 = -1
     * Se espera que el resultado sea -2.5
     */
    @Test
    public void solucionaEcuacionConParte3NegativaYCoeficienteDecimal() throws Exception {
        Double result = ecuacion.obtenerResultado("0.2x - 0.5 = -1");
        Double valueExpected = -2.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }

    /**
     * Prueba la solución de una ecuación donde parte3 es un decimal.
     * Ecuación: 3x + 4 = 5.5
     * Se espera que el resultado sea 0.5
     */
    @Test
    public void solucionaEcuacionConParte3Decimal() throws Exception {
        Double result = ecuacion.obtenerResultado("3x + 4 = 5.5");
        Double valueExpected = 0.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }
}
