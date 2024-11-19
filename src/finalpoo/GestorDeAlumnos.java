package finalpoo;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase GestorDeAlumnos
 * Permite gestionar el CRUD de alumnos en el sistema.
 * 
 * Autor: Ivan Ocadiz
 */
public class GestorDeAlumnos {

    // Lista para almacenar los alumnos
    private List<Alumno> alumnos;

    // Constructor
    public GestorDeAlumnos() {
        this.alumnos = new ArrayList<>(); // Inicializa la lista vacía
    }

    /**
     * Agrega un nuevo alumno al sistema.
     * @param alumno El objeto Alumno a agregar.
     */
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        System.out.println("Alumno agregado exitosamente: " + alumno.getNumeroCuenta());
    }

    /**
     * Busca un alumno por su número de cuenta.
     * @param numeroCuenta El número de cuenta del alumno a buscar.
     * @return El objeto Alumno si se encuentra, null en caso contrario.
     */
    public Alumno buscarAlumno(String numeroCuenta) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNumeroCuenta().equals(numeroCuenta)) {
                return alumno;
            }
        }
        System.out.println("Alumno no encontrado.");
        return null;
    }

    /**
     * Actualiza los datos de un alumno existente.
     * @param numeroCuenta El número de cuenta del alumno a actualizar.
     * @param nuevoAlumno Los nuevos datos del alumno.
     */
    public void actualizarAlumno(String numeroCuenta, Alumno nuevoAlumno) {
        Alumno alumnoExistente = buscarAlumno(numeroCuenta);
        if (alumnoExistente != null) {
            alumnos.remove(alumnoExistente); // Elimina el alumno anterior
            alumnos.add(nuevoAlumno);       // Agrega los nuevos datos
            System.out.println("Alumno actualizado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado. No se pudo actualizar.");
        }
    }

    /**
     * Elimina un alumno del sistema.
     * @param numeroCuenta El número de cuenta del alumno a eliminar.
     */
    public void eliminarAlumno(String numeroCuenta) {
        Alumno alumno = buscarAlumno(numeroCuenta);
        if (alumno != null) {
            alumnos.remove(alumno); // Elimina el alumno de la lista
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado. No se pudo eliminar.");
        }
    }

    /**
     * Muestra la lista de todos los alumnos registrados.
     */
    public void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno alumno : alumnos) {
                System.out.println(alumno); // Usa el método toString() de Alumno
            }
        }
    }

    /**
     * Devuelve la lista de alumnos registrada en el gestor.
     * @return Lista de alumnos.
     */
    public List<Alumno> getAlumnos() {
        return alumnos; // Retorna la lista para su uso en otras clases
    }

    /**
     * Reemplaza la lista actual de alumnos por una nueva lista.
     * @param alumnos La nueva lista de alumnos.
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
