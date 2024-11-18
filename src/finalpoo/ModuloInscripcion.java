/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

/**
 * Clase ModuloInscripcion
 * Gestiona el cálculo de indicadores escolares y la asignación de números de inscripción.
 * 
 * Autor: Ivan Ocadiz
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase ModuloInscripcion
 * Se encarga de procesar inscripciones y asignar números de inscripción a los alumnos
 * basándose en su indicador escolar.
 */
public class ModuloInscripcion {

    /**
     * Procesa las inscripciones de los alumnos.
     * Ordena a los alumnos por su indicador escolar en orden descendente
     * y asigna números de inscripción consecutivos empezando desde el 1.
     *
     * @param alumnos Lista de alumnos a inscribir.
     */
    public void procesarInscripciones(List<Alumno> alumnos) {
        // Ordenar alumnos por indicador escolar en orden descendente
        alumnos.sort((a, b) -> Double.compare(b.getIndicadorEscolar(), a.getIndicadorEscolar()));

        // Asignar número de inscripción basado en el orden
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).setNumeroInscripcion(i + 1);
        }

        System.out.println("Números de inscripción asignados correctamente.");
    }

    /**
     * Muestra la lista de alumnos con sus números de inscripción asignados.
     *
     * @param alumnos Lista de alumnos.
     */
    public void mostrarInscripciones(List<Alumno> alumnos) {
        System.out.println("Lista de Inscripciones:");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNumeroCuenta() + ", Indicador Escolar: " + alumno.getIndicadorEscolar() + ", Número de Inscripción: " + alumno.getNumeroInscripcion());
        }
    }
}
