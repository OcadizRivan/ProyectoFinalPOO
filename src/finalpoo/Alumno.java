package finalpoo;

/**
 * Clase Alumno
 * Representa a un alumno con sus datos personales, académicos y su indicador escolar.
 * Proporciona funcionalidades para calcular estadísticas académicas y gestionar su información.
 * 
 * @author EquipoE
 */
public class Alumno {
    // **Atributos**
    /**
     * Número único del alumno.
     */
    private String numeroCuenta;

    /**
     * Nombre(s) del alumno.
     */
    private String nombre;

    /**
     * Apellido(s) del alumno.
     */
    private String apellido;

    /**
     * Dirección del alumno.
     */
    private String direccion;

    /**
     * Edad del alumno.
     */
    private int edad;

    /**
     * Semestre actual del alumno.
     */
    private int semestre;

    /**
     * Créditos de las materias cursadas por el alumno.
     */
    private int[] creditos;

    /**
     * Total de créditos acumulados por el alumno desde el ingreso.
     */
    private int totalCreditos;

    /**
     * Promedio de las calificaciones obtenidas por el alumno.
     */
    private double promedio;

    /**
     * Porcentaje de materias aprobadas (escolaridad) del alumno.
     */
    private double escolaridad;

    /**
     * Porcentaje de créditos aprobados por el alumno.
     */
    private double velocidad;

    /**
     * Indicador escolar calculado para el alumno.
     */
    private double indicadorEscolar;

    /**
     * Número de inscripción asignado al alumno.
     */
    private int numeroInscripcion;

    // **Constructor**
    /**
     * Constructor de la clase Alumno.
     * 
     * @param numeroCuenta Número único del alumno.
     * @param nombre Nombre del alumno.
     * @param apellido Apellido del alumno.
     * @param direccion Dirección del alumno.
     * @param edad Edad del alumno.
     * @param semestre Semestre actual del alumno.
     * @param creditos Créditos de las materias cursadas por el alumno.
     */
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

    // **Getters y Setters**
    /** Devuelve el número único del alumno. */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /** Establece el número único del alumno. */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /** Devuelve el nombre del alumno. */
    public String getNombre() {
        return nombre;
    }

    /** Establece el nombre del alumno. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Devuelve el apellido del alumno. */
    public String getApellido() {
        return apellido;
    }

    /** Establece el apellido del alumno. */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /** Devuelve la dirección del alumno. */
    public String getDireccion() {
        return direccion;
    }

    /** Establece la dirección del alumno. */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** Devuelve la edad del alumno. */
    public int getEdad() {
        return edad;
    }

    /** Establece la edad del alumno. */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /** Devuelve el semestre actual del alumno. */
    public int getSemestre() {
        return semestre;
    }

    /** Establece el semestre actual del alumno. */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /** Devuelve los créditos de las materias cursadas. */
    public int[] getCreditos() {
        return creditos;
    }

    /** Establece los créditos de las materias cursadas. */
    public void setCreditos(int[] creditos) {
        this.creditos = creditos;
    }

    /** Devuelve el total de créditos acumulados. */
    public int getTotalCreditos() {
        return totalCreditos;
    }

    /** Establece el total de créditos acumulados. */
    public void setTotalCreditos(int totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    /** Devuelve el promedio de calificaciones. */
    public double getPromedio() {
        return promedio;
    }

    /** Establece el promedio de calificaciones. */
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    /** Devuelve el porcentaje de escolaridad (materias aprobadas). */
    public double getEscolaridad() {
        return escolaridad;
    }

    /** Establece el porcentaje de escolaridad (materias aprobadas). */
    public void setEscolaridad(double escolaridad) {
        this.escolaridad = escolaridad;
    }

    /** Devuelve el porcentaje de créditos aprobados. */
    public double getVelocidad() {
        return velocidad;
    }

    /** Establece el porcentaje de créditos aprobados. */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /** Devuelve el indicador escolar. */
    public double getIndicadorEscolar() {
        return indicadorEscolar;
    }

    /** Establece el indicador escolar. */
    public void setIndicadorEscolar(double indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    /** Devuelve el número de inscripción del alumno. */
    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    /** Establece el número de inscripción del alumno. */
    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    // **Métodos específicos**

    /**
     * Calcula el promedio de las calificaciones.
     * 
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
     * 
     * @param asignaturasAprobadas Número de asignaturas aprobadas.
     * @param totalAsignaturas Total de asignaturas cursadas.
     * @return Porcentaje de escolaridad.
     */
    private double calcularEscolaridad(int asignaturasAprobadas, int totalAsignaturas) {
        return ((double) asignaturasAprobadas / totalAsignaturas) * 100; // En porcentaje
    }

    /**
     * Calcula la velocidad en términos de créditos aprobados.
     * 
     * @param creditosAprobados Créditos aprobados por el alumno.
     * @param totalCreditos Total de créditos cursados.
     * @return Porcentaje de velocidad.
     */
    private double calcularVelocidad(int creditosAprobados, int totalCreditos) {
        return ((double) creditosAprobados / totalCreditos) * 100; // En porcentaje
    }

    /**
     * Calcula el indicador escolar usando la fórmula proporcionada.
     * 
     * @return Indicador escolar calculado.
     */
    public double calcularIndicadorEscolar() {
        return this.promedio * this.escolaridad * this.velocidad;
    }

    /**
     * Devuelve una representación en texto del alumno.
     * 
     * @return Cadena con los datos del alumno.
     */
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
