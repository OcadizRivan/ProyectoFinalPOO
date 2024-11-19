package finalpoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestorDeAlumnos
 * Proporciona funcionalidades para gestionar alumnos en el sistema mediante operaciones CRUD
 * (Crear, Leer, Actualizar, Eliminar). Almacena los alumnos en una lista y ofrece métodos para
 * manipular y acceder a sus datos.
 * 
 * Esta clase actúa como un controlador para centralizar la gestión de los datos de los alumnos.
 * 
 * @author EquipoE
 */
public class GestorDeAlumnos {

    // **Atributos**
    /**
     * Lista de alumnos registrados en el sistema.
     */
    private List<Alumno> alumnos;

    // **Constructor**
    /**
     * Constructor de la clase GestorDeAlumnos.
     * Inicializa la lista de alumnos como una lista vacía.
     */
    public GestorDeAlumnos() {
        this.alumnos = new ArrayList<>(); // Inicializa la lista vacía
    }

    // **Métodos**

    /**
     * Agrega un nuevo alumno al sistema.
     * 
     * @param alumno El objeto `Alumno` a agregar.
     */
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        System.out.println("Alumno agregado exitosamente: " + alumno.getNumeroCuenta());
    }

    /**
     * Busca un alumno en el sistema utilizando su número de cuenta.
     * 
     * @param numeroCuenta El número de cuenta del alumno a buscar.
     * @return El objeto `Alumno` si se encuentra, `null` en caso contrario.
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
     * Actualiza los datos de un alumno existente en el sistema.
     * 
     * @param numeroCuenta El número de cuenta del alumno a actualizar.
     * @param nuevoAlumno El objeto `Alumno` con los nuevos datos.
     */
    public void actualizarAlumno(String numeroCuenta, Alumno nuevoAlumno) {
        Alumno alumnoExistente = buscarAlumno(numeroCuenta);
        if (alumnoExistente != null) {
            alumnos.remove(alumnoExistente); // Elimina al alumno existente
            alumnos.add(nuevoAlumno);       // Agrega el nuevo objeto con los datos actualizados
            System.out.println("Alumno actualizado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado. No se pudo actualizar.");
        }
    }

    /**
     * Elimina un alumno del sistema utilizando su número de cuenta.
     * 
     * @param numeroCuenta El número de cuenta del alumno a eliminar.
     */
    public void eliminarAlumno(String numeroCuenta) {
        Alumno alumno = buscarAlumno(numeroCuenta);
        if (alumno != null) {
            alumnos.remove(alumno); // Elimina el objeto del alumno de la lista
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado. No se pudo eliminar.");
        }
    }

    /**
     * Muestra la lista de todos los alumnos registrados en el sistema.
     * Imprime los datos de cada alumno utilizando su método `toString`.
     */
    public void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno alumno : alumnos) {
                System.out.println(alumno); // Usa el método `toString` de la clase Alumno
            }
        }
    }

    /**
     * Devuelve la lista de alumnos registrada en el gestor.
     * 
     * @return La lista de alumnos.
     */
    public List<Alumno> getAlumnos() {
        return alumnos; // Retorna la lista completa para su uso en otras clases o métodos
    }

    /**
     * Reemplaza la lista actual de alumnos por una nueva lista.
     * 
     * @param alumnos La nueva lista de alumnos a establecer.
     */
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
