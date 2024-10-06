import static org.junit.jupiter.api.Assertions.assertEquals; // Importa método para verificar igualdad en JUnit 5
import static org.mockito.Mockito.when; // Importa método para simular comportamiento en Mockito

import org.junit.jupiter.api.BeforeEach; // Importa la anotación para configurar antes de cada prueba
import org.junit.jupiter.api.Test; // Importa la anotación Test de JUnit 5
import org.mockito.InjectMocks; // Importa la anotación para inyectar mocks
import org.mockito.Mock; // Importa la anotación para crear un mock
import org.mockito.MockitoAnnotations; // Importa la clase para inicializar anotaciones de Mockito

public class EcuacionPrimerGradoMockitoTest {

    @InjectMocks // Anotación que indica que los mocks se inyectarán en esta clase
    private EcuacionPrimerGrado ecuacionPrimerGrado; // Instancia de la clase que se va a probar

    @Mock // Anotación que indica que esta variable es un mock
    private Parseador parseador; // Mock de la clase Parseador, que se usará para simular sus métodos

    @BeforeEach // Método que se ejecuta antes de cada prueba
    public void inicializaMocks() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks y inyecta los objetos necesarios
    }

    /**
     * Prueba la solución de una ecuación con un término negativo en el lado izquierdo.
     * Ecuación: 2x - 1 = 0
     * Se espera que el resultado sea 0.5
     */
    @Test
    public void solucionaEcuacionConMenos() {
        String ecuacion = "2x - 1 = 0"; // Define la ecuación a probar
        // Configura el comportamiento del mock parseador
        when(parseador.obtenerParte1(ecuacion)).thenReturn(2); // Simula el retorno de parte1
        when(parseador.obtenerParte2(ecuacion)).thenReturn(-1); // Simula el retorno de parte2
        when(parseador.obtenerParte3(ecuacion)).thenReturn(0); // Simula el retorno de parte3
        Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion); // Llama al método que se está probando
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
        String ecuacion = "2x + 1 = 0"; // Define la ecuación a probar
        // Configura el comportamiento del mock parseador
        when(parseador.obtenerParte1(ecuacion)).thenReturn(2); // Simula el retorno de parte1
        when(parseador.obtenerParte2(ecuacion)).thenReturn(1); // Simula el retorno de parte2
        when(parseador.obtenerParte3(ecuacion)).thenReturn(0); // Simula el retorno de parte3
        Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion); // Llama al método que se está probando
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
        String ecuacion = "2x + 1 = 10"; // Define la ecuación a probar
        // Configura el comportamiento del mock parseador
        when(parseador.obtenerParte1(ecuacion)).thenReturn(2); // Simula el retorno de parte1
        when(parseador.obtenerParte2(ecuacion)).thenReturn(1); // Simula el retorno de parte2
        when(parseador.obtenerParte3(ecuacion)).thenReturn(10); // Simula el retorno de parte3
        Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion); // Llama al método que se está probando
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
        String ecuacion = "2x + 1 = -10"; // Define la ecuación a probar
        // Configura el comportamiento del mock parseador
        when(parseador.obtenerParte1(ecuacion)).thenReturn(2); // Simula el retorno de parte1
        when(parseador.obtenerParte2(ecuacion)).thenReturn(1); // Simula el retorno de parte2
        when(parseador.obtenerParte3(ecuacion)).thenReturn(-10); // Simula el retorno de parte3
        Double result = ecuacionPrimerGrado.obtenerResultado(ecuacion); // Llama al método que se está probando
        Double valueExpected = -5.5; // Resultado esperado
        assertEquals(valueExpected, result); // Verifica que el resultado sea igual al esperado
    }
}

