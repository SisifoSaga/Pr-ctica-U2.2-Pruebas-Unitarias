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
        String ecuacion = "2x - 1 = 0"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte1(ecuacion); // Llama al método obtenerParte1
        assertEquals(2.0, resultado, 0.0001); // Verifica que el resultado sea igual a 2.0
    }

    /**
     * Prueba el método obtenerParte1 para una ecuación con decenas.
     * Ecuación: "20x - 1 = 0"
     * Se espera que el resultado sea 20.
     */
    @Test
    public void obtenerParte1Decenas() {
        String ecuacion = "20x - 1 = 0"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte1(ecuacion); // Llama al método obtenerParte1
        assertEquals(20.0, resultado, 0.0001); // Verifica que el resultado sea igual a 20.0
    }

    /**
     * Prueba el método obtenerParte2 para una ecuación que contiene una resta.
     * Ecuación: "2x - 1 = 0"
     * Se espera que el resultado sea -1.
     */
    @Test
    public void obtenerParte2Resta() {
        String ecuacion = "2x - 1 = 0"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte2(ecuacion); // Llama al método obtenerParte2
        assertEquals(-1.0, resultado, 0.0001); // Verifica que el resultado sea igual a -1.0
    }

    /**
     * Prueba el método obtenerParte2 para una ecuación que contiene una suma.
     * Ecuación: "2x + 1 = 0"
     * Se espera que el resultado sea 1.
     */
    @Test
    public void obtenerParte2Suma() {
        String ecuacion = "2x + 1 = 0"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte2(ecuacion); // Llama al método obtenerParte2
        assertEquals(1.0, resultado, 0.0001); // Verifica que el resultado sea igual a 1.0
    }

    /**
     * Prueba el método obtenerParte3 para una ecuación donde parte3 es positiva.
     * Ecuación: "2x + 1 = 3"
     * Se espera que el resultado sea 3.
     */
    @Test
    public void obtenerParte3Positivo() {
        String ecuacion = "2x + 1 = 3"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte3(ecuacion); // Llama al método obtenerParte3
        assertEquals(3.0, resultado, 0.0001); // Verifica que el resultado sea igual a 3.0
    }

    /**
     * Prueba el método obtenerParte3 para una ecuación donde parte3 es negativa.
     * Ecuación: "2x + 1 = -3"
     * Se espera que el resultado sea -3.
     */
    @Test
    public void obtenerParte3Negativo() {
        String ecuacion = "2x + 1 = -3"; // Define la ecuación a probar
        double resultado = parseador.obtenerParte3(ecuacion); // Llama al método obtenerParte3
        assertEquals(-3.0, resultado, 0.0001); // Verifica que el resultado sea igual a -3.0
    }

    /**
     * Prueba el método obtenerOperador para una ecuación que contiene una resta.
     * Ecuación: "2x - 1 = 0"
     * Se espera que el operador sea "-".
     */
    @Test
    public void obtenerOperadorResta() {
        String ecuacion = "2x - 1 = 0"; // Define la ecuación a probar
        String operador = parseador.obtenerOperador(ecuacion); // Llama al método obtenerOperador
        assertEquals("-", operador); // Verifica que el operador sea igual a "-"
    }

    /**
     * Prueba el método obtenerOperador para una ecuación que contiene una suma.
     * Ecuación: "2x + 1 = 0"
     * Se espera que el operador sea "+".
     */
    @Test
    public void obtenerOperadorSuma() {
        String ecuacion = "2x + 1 = 0"; // Define la ecuación a probar
        String operador = parseador.obtenerOperador(ecuacion); // Llama al método obtenerOperador
        assertEquals("+", operador); // Verifica que el operador sea igual a "+"
    }
}
