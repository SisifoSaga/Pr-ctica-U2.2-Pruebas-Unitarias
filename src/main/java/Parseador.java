public class Parseador {

    /**
     * Obtiene la parte1 (coeficiente de x) de la ecuación.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return El coeficiente de x como un entero
     */
    public int obtenerParte1(final String ecuacion) {
        // Obtiene las partes de la ecuación (parte1 y parte2) usando el método auxiliar
        String[] partes1 = obtenerPartes12(ecuacion);

        // Extrae la parte1 (coeficiente de x) y elimina espacios en blanco
        String parte1 = partes1[0].trim();

        // Convierte la parte1 a entero, omitiendo la última letra 'x'
        return Integer.valueOf(parte1.substring(0, parte1.length() - 1));
    }

    /**
     * Obtiene la parte2 (constante sumada o restada) de la ecuación.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return La parte2 como un entero (puede ser negativo)
     */
    public int obtenerParte2(final String ecuacion) {
        // Obtiene las partes de la ecuación (parte1 y parte2) usando el método auxiliar
        String[] partes1 = obtenerPartes12(ecuacion);

        // Extrae la parte2 y elimina espacios en blanco
        String parte2 = partes1[1].trim();

        // Obtiene el operador (suma o resta) de la ecuación
        String operador = obtenerOperador(ecuacion);

        // Si el operador es "-", convierte parte2 a negativo
        if ("-".equals(operador)) {
            return Integer.valueOf(parte2) * (-1);
        }
        // Si el operador es "+", retorna parte2 como está
        return Integer.valueOf(parte2);
    }

    /**
     * Obtiene el operador de la ecuación (puede ser '+' o '-').
     *
     * @param ecuacion Cadena que representa la ecuación
     * @return El operador como una cadena
     */
    public String obtenerOperador(final String ecuacion) {
        // Verifica si existe el operador '+' en la ecuación
        if (ecuacion.indexOf('+') > 0) {
            return "+";
        } else {
            return "-"; // Si no se encuentra '+', se asume que es '-'
        }
    }

    /**
     * Obtiene la parte3 (constante igualada) de la ecuación.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return La parte3 como un entero
     */
    public int obtenerParte3(final String ecuacion) {
        // Divide la ecuación en dos partes usando el símbolo '='
        String[] partesEcuacion = ecuacion.split("=");

        // Convierte la parte3 (lado derecho de la ecuación) a entero
        return Integer.valueOf(partesEcuacion[1].trim());
    }

    /**
     * Obtiene parte1 y parte2 de la ecuación como un arreglo de cadenas.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return Un arreglo de cadenas que contiene parte1 y parte2
     */
    private String[] obtenerPartes12(final String ecuacion) {
        // Divide la ecuación en partes usando el símbolo '='
        String[] partesEcuacion = ecuacion.split("=");

        // Obtiene el operador de la ecuación
        String operador = obtenerOperador(ecuacion);

        // Divide la parte izquierda de la ecuación (ax + b) usando el operador encontrado
        String[] partes1 = partesEcuacion[0].split("\\s*\\Q" + operador + "\\E\\s*");

        // Retorna un arreglo que contiene parte1 y parte2
        return partes1;
    }
}
