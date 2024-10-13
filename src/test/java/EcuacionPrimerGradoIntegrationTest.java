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

    /**
     * Prueba la solución de una ecuación con un término positivo en el lado izquierdo.
     * Ecuación: 2x + 1 = 0
     * Se espera que el resultado sea -0.5
     */
    @Test
    public void solucionaEcuacionConMas() throws Exception {
        Double result = ecuacion.obtenerResultado("2x + 1 = 0");
        Double valueExpected = -0.5; // Resultado esperado
        assertEquals(valueExpected, result);
    }
