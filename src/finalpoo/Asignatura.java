package finalpoo;

/**
 * Clase Asignatura
 * Representa una asignatura cursada por un alumno, incluyendo sus créditos y la calificación obtenida.
 * 
 * Esta clase encapsula los datos básicos de una asignatura, como el número de créditos y la calificación,
 * y proporciona métodos para acceder y modificar dichos datos.
 * 
 * @author EquipoE
 */
public class Asignatura {

    // **Atributos**
    /**
     * Número de créditos asignados a la asignatura.
     */
    private int creditos;

    /**
     * Calificación obtenida por el alumno en la asignatura.
     */
    private double calificacion;

    // **Constructor**
    /**
     * Constructor de la clase Asignatura.
     * Inicializa los atributos con los valores proporcionados.
     * 
     * @param creditos Número de créditos de la asignatura.
     * @param calificacion Calificación obtenida en la asignatura.
     */
    public Asignatura(int creditos, double calificacion) {
        this.creditos = creditos;
        this.calificacion = calificacion;
    }

    // **Getters y Setters**

    /**
     * Devuelve el número de créditos de la asignatura.
     * 
     * @return El número de créditos.
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Establece el número de créditos de la asignatura.
     * 
     * @param creditos El número de créditos a asignar.
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Devuelve la calificación obtenida en la asignatura.
     * 
     * @return La calificación.
     */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     * Establece la calificación obtenida en la asignatura.
     * 
     * @param calificacion La calificación a asignar.
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // **Métodos Sobrescritos**

    /**
     * Devuelve una representación en forma de texto de la asignatura,
     * mostrando el número de créditos y la calificación obtenida.
     * 
     * @return Cadena de texto representando la asignatura.
     */
    @Override
    public String toString() {
        return "Asignatura{" +
                "creditos=" + creditos +
                ", calificacion=" + calificacion +
                '}';
    }
}
