import static org.junit.jupiter.api.Assertions.assertEquals; // Importa el método assertEquals para verificar la igualdad en JUnit 5
import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit 5

public class ParseadorTest {

    private final Parseador parseador = new Parseador(); // Crea una instancia de la clase Parseador para usar en las pruebas

    /**
     * Prueba el método obtenerParte1 para una ecuación con unidades.
     * Ecuación: "2x - 1 = 0"
     * Se espera que el resultado sea 2.
     */
    @Test
    public void obtenerParte1Unidades() {
        String ecuacion1 = "2x - 1 = 0"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte1(ecuacion1); // Llama al método obtenerParte1
        assertEquals(2, resultado); // Verifica que el resultado sea igual a 2
    }

    /**
     * Prueba el método obtenerParte1 para una ecuación con decenas.
     * Ecuación: "20x - 1 = 0"
     * Se espera que el resultado sea 20.
     */
    @Test
    public void obtenerParte1Decenas() {
        String ecuacion2 = "20x - 1 = 0"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte1(ecuacion2); // Llama al método obtenerParte1
        assertEquals(20, resultado); // Verifica que el resultado sea igual a 20
    }

    /**
     * Prueba el método obtenerParte2 para una ecuación que contiene una resta.
     * Ecuación: "2x - 1 = 0"
     * Se espera que el resultado sea -1.
     */
    @Test
    public void obtenerParte2Resta() {
        String ecuacion1 = "2x - 1 = 0"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte2(ecuacion1); // Llama al método obtenerParte2
        assertEquals(-1, resultado); // Verifica que el resultado sea igual a -1
    }

    /**
     * Prueba el método obtenerParte2 para una ecuación que contiene una suma.
     * Ecuación: "2x + 1 = 0"
     * Se espera que el resultado sea 1.
     */
    @Test
    public void obtenerParte2Suma() {
        String ecuacion1 = "2x + 1 = 0"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte2(ecuacion1); // Llama al método obtenerParte2
        assertEquals(1, resultado); // Verifica que el resultado sea igual a 1
    }

    /**
     * Prueba el método obtenerParte3 para una ecuación donde parte3 es positiva.
     * Ecuación: "2x + 1 = 3"
     * Se espera que el resultado sea 3.
     */
    @Test
    public void obtenerParte3Positivo() {
        String ecuacion1 = "2x + 1 = 3"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte3(ecuacion1); // Llama al método obtenerParte3
        assertEquals(3, resultado); // Verifica que el resultado sea igual a 3
    }

    /**
     * Prueba el método obtenerParte3 para una ecuación donde parte3 es negativa.
     * Ecuación: "2x + 1 = -3"
     * Se espera que el resultado sea -3.
     */
    @Test
    public void obtenerParte3Negativo() {
        String ecuacion1 = "2x + 1 = -3"; // Define la ecuación a probar
        int resultado = parseador.obtenerParte3(ecuacion1); // Llama al método obtenerParte3
        assertEquals(-3, resultado); // Verifica que el resultado sea igual a -3
    }

    /**
     * Prueba el método obtenerOperador para una ecuación que contiene una resta.
     * Ecuación: "2x - 1 = 0"
     * Se espera que el operador sea "-".
     */
    @Test
    public void obtenerOperadorResta() {
        String ecuacion2 = "2x - 1 = 0"; // Define la ecuación a probar
        String operador = parseador.obtenerOperador(ecuacion2); // Llama al método obtenerOperador
        assertEquals("-", operador); // Verifica que el operador sea igual a "-"
    }

    /**
     * Prueba el método obtenerOperador para una ecuación que contiene una suma.
     * Ecuación: "2x + 1 = 0"
     * Se espera que el operador sea "+".
     */
    @Test
    public void obtenerOperadorSuma() {
        String ecuacion2 = "2x + 1 = 0"; // Define la ecuación a probar
        String operador = parseador.obtenerOperador(ecuacion2); // Llama al método obtenerOperador
        assertEquals("+", operador); // Verifica que el operador sea igual a "+"
    }
}
