package finalpoo;

/**
 * Clase Asignatura
 * Representa una asignatura cursada por un alumno, incluyendo su nombre, calificación y créditos.
 * 
 * Autor: Ivan Ocadiz
 */
public class Asignatura {

    // Atributos
    private int creditos;         // Número de créditos de la asignatura
    private double calificacion;  // Calificación obtenida en la asignatura

    // Constructor
    public Asignatura(int creditos, double calificacion) {
        this.creditos = creditos;
        this.calificacion = calificacion;
    }

    // Getters y Setters

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "creditos=" + creditos +
                ", calificacion=" + calificacion +
                '}';
    }
}
