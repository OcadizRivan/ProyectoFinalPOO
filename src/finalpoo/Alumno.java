/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

import java.util.List;

/**
 * Clase Alumno
 * Representa a un alumno con sus datos personales, académicos y su indicador escolar.
 * 
 * @author: Ivan Ocadiz
 */    
public class Alumno {
    // Atributos
    private String numeroCuenta;      // Número único del alumno.
    private String nombre;            // Nombre(s) del alumno.
    private String apellido;          // Apellido(s) del alumno.
    private String direccion;         // Dirección del alumno.
    private int edad;                 // Edad del alumno.
    private int semestre;             // Semestre actual del alumno.
    private int[] creditos;           // Créditos de las materias cursadas.
    private int totalCreditos;        // Total de créditos desde el ingreso.
    private double promedio;          // Promedio de las calificaciones.
    private double escolaridad;       // Porcentaje de materias aprobadas.
    private double velocidad;         // Porcentaje de créditos aprobados.
    private double indicadorEscolar;  // Indicador escolar calculado.
    private int numeroInscripcion;    // Número de inscripción asignado.

    // Constructor
    public Alumno(String numeroCuenta, String nombre, String apellido, String direccion, 
                  int edad, int semestre, int[] creditos) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.semestre = semestre;
        this.creditos = creditos;

        // Calcular total de créditos
        this.totalCreditos = 0;
        for (int credito : creditos) {
            this.totalCreditos += credito;
        }

        // Generar calificaciones aleatorias para las asignaturas cursadas
        double[] calificaciones = new double[creditos.length];
        int asignaturasAprobadas = 0;
        int creditosAprobados = 0;
        for (int i = 0; i < creditos.length; i++) {
            calificaciones[i] = Math.random() * 50 + 50; // Calificaciones entre 50 y 100
            if (calificaciones[i] >= 60) { // Aprobatoria
                asignaturasAprobadas++;
                creditosAprobados += creditos[i];
            }
        }
        this.promedio = calcularPromedio(calificaciones);
        this.escolaridad = calcularEscolaridad(asignaturasAprobadas, calificaciones.length);
        this.velocidad = calcularVelocidad(creditosAprobados, this.totalCreditos);

        // Calcular indicador escolar
        this.indicadorEscolar = this.promedio * this.escolaridad * this.velocidad;

        // Inicializar el número de inscripción
        this.numeroInscripcion = 0;
    }

    Alumno(String cuentaActualizar, String nuevoNombre, String nuevoApellido, String nuevaDireccion, int nuevaEdad, int nuevoSemestre, double[] d, int[] i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int[] getCreditos() {
        return creditos;
    }

    public void setCreditos(int[] creditos) {
        this.creditos = creditos;
    }

    public int getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(int totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(double escolaridad) {
        this.escolaridad = escolaridad;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getIndicadorEscolar() {
        return indicadorEscolar;
    }

    public void setIndicadorEscolar(double indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    // Métodos específicos

    /**
     * Calcula el promedio de las calificaciones.
     * @param calificaciones Arreglo de calificaciones.
     * @return Promedio calculado.
     */
    private double calcularPromedio(double[] calificaciones) {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    /**
     * Calcula el porcentaje de materias aprobadas (escolaridad).
     * @param asignaturasAprobadas Número de asignaturas aprobadas.
     * @param totalAsignaturas Total de asignaturas cursadas.
     * @return Porcentaje de escolaridad.
     */
    private double calcularEscolaridad(int asignaturasAprobadas, int totalAsignaturas) {
        return ((double) asignaturasAprobadas / totalAsignaturas) * 100; // En porcentaje
    }

    /**
     * Calcula la velocidad en términos de créditos aprobados.
     * @param creditosAprobados Créditos aprobados por el alumno.
     * @param totalCreditos Total de créditos cursados.
     * @return Porcentaje de velocidad.
     */
    private double calcularVelocidad(int creditosAprobados, int totalCreditos) {
        return ((double) creditosAprobados / totalCreditos) * 100; // En porcentaje
    }

    /**
     * Calcula el indicador escolar usando la fórmula proporcionada.
     * @return Indicador escolar calculado.
     */
    public double calcularIndicadorEscolar() {
        return this.promedio * this.escolaridad * this.velocidad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad=" + edad +
                ", semestre=" + semestre +
                ", promedio=" + promedio +
                ", escolaridad=" + escolaridad +
                ", velocidad=" + velocidad +
                ", indicadorEscolar=" + indicadorEscolar +
                ", numeroInscripcion=" + numeroInscripcion +
                '}';
    }
}
