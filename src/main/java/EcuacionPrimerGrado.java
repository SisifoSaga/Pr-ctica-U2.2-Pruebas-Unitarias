/**
 * Clase que representa una ecuación de primer grado en el formato:
 *
 * ax + b = c
 *
 * Donde:
 * a : parte1 (coeficiente de x)
 * b : parte2 (constante sumada o restada)
 * + : operador (puede ser '+' o '-')
 * c : parte3 (constante igualada en el lado derecho de la ecuación)
 *
 * La solución de la ecuación se obtiene mediante la fórmula:
 * x = (c - b) / a
 * Lo que se traduce en:
 *
 * x = (parte3 - parte2) / parte1
 */
public class EcuacionPrimerGrado {

    // Instancia de la clase Parseador que se utilizará para descomponer la ecuación
    private Parseador parseador = new Parseador();

    /**
     * Método que calcula el resultado de la ecuación de primer grado.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return El valor de x que satisface la ecuación
     */
    public double obtenerResultado(final String ecuacion) {

        // Obtiene la parte1 (coeficiente de x) de la ecuación usando el parseador
        int parte1 = parseador.obtenerParte1(ecuacion);

        // Obtiene la parte2 (constante sumada o restada) de la ecuación usando el parseador
        int parte2 = parseador.obtenerParte2(ecuacion);

        // Obtiene la parte3 (constante igualada en el lado derecho de la ecuación) usando el parseador
        int parte3 = parseador.obtenerParte3(ecuacion);

        // Calcula el resultado de x utilizando la fórmula x = (parte3 - parte2) / parte1
        double resultado = (double) (parte3 - parte2) / parte1;

        // Devuelve el resultado calculado
        return resultado;
    }
}

