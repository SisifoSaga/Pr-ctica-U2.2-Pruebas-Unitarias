public class EcuacionPrimerGrado {

    private Parseador parseador = new Parseador();

    /**
     * Método que calcula el resultado de la ecuación de primer grado.
     *
     * @param ecuacion Cadena que representa la ecuación en formato ax + b = c
     * @return El valor de x que satisface la ecuación o lanza una excepción si no hay solución.
     * @throws Exception Si la ecuación no tiene solución o tiene infinitas soluciones.
     */
    public Double obtenerResultado(final String ecuacion) throws Exception {
        double parte1 = parseador.obtenerParte1(ecuacion);
        double parte2 = parseador.obtenerParte2(ecuacion);
        double parte3 = parseador.obtenerParte3(ecuacion);

        // Validar si el coeficiente de x es 0
        if (parte1 == 0) {
            if (parte2 == parte3) {
                throw new Exception("La ecuación tiene infinitas soluciones.");
            } else {
                throw new Exception("La ecuación no tiene solución.");
            }
        }

        // Solución normal: x = (parte3 - parte2) / parte1
        return (parte3 - parte2) / parte1;
    }

    /**
     * Método para simplificar ecuaciones más complejas si es necesario.
     *
     * @param ecuacion Cadena que representa la ecuación a simplificar.
     * @return La ecuación simplificada en formato ax + b = c.
     */
    public String simplificarEcuacion(String ecuacion) {
        // Aquí podrías agregar lógica para reordenar términos o simplificar la ecuación.
        // Esta función es solo un ejemplo para futuras mejoras.
        return ecuacion;
    }
}

