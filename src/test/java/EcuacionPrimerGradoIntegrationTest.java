import static org.junit.jupiter.api.Assertions.assertEquals; // Importa método para verificar igualdad en JUnit 5
import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit 5

public class EcuacionPrimerGradoIntegrationTest {

    // Crea una instancia de la clase EcuacionPrimerGrado para realizar pruebas
    EcuacionPrimerGrado ecuacion = new EcuacionPrimerGrado();

    /**
     * Prueba la solución de una ecuación con un término negativo en el lado izquierdo.
     * Ecuación: 2x - 1 = 0
     * Se espera que el resultado sea 0.5
     */
    @Test
    public void solucionaEcuacionConMenos() {
        Double result = ecuacion.obtenerResultado("2x - 1 = 0");
        Double valueExpected = 0.5; // Resultado esperado
        assertEquals(valueExpected, result); // Verifica que el resultado sea igual al esperado
    }

    /**
     * Prueba la solución de una ecuación con un término positivo en el lado izquierdo.
     * Ecuación: 2x + 1 = 0
     * Se espera que el resultado sea -0.5
     */
    @Test
    public void solucionaEcuacionConMas() {
        Double result = ecuacion.obtenerResultado("2x + 1 = 0");
        Double valueExpected = -0.5; // Resultado esperado
        assertEquals(valueExpected, result); // Verifica que el resultado sea igual al esperado
    }

    /**
     * Prueba la solución de una ecuación donde parte3 es mayor que cero.
     * Ecuación: 2x + 1 = 10
     * Se espera que el resultado sea 4.5
     */
    @Test
    public void solucionaEcuacionConParte3Mayor0() {
        Double result = ecuacion.obtenerResultado("2x + 1 = 10");
        Double valueExpected = 4.5; // Resultado esperado
        assertEquals(valueExpected, result); // Verifica que el resultado sea igual al esperado
    }

    /**
     * Prueba la solución de una ecuación donde parte3 es menor que cero.
     * Ecuación: 2x + 1 = -10
     * Se espera que el resultado sea -5.5
     */
    @Test
    public void solucionaEcuacionConParte3Menor0() {
        Double result = ecuacion.obtenerResultado("2x + 1 = -10");
        Double valueExpected = -5.5; // Resultado esperado
        assertEquals(valueExpected, result); // Verifica que el resultado sea igual al esperado
    }
}
