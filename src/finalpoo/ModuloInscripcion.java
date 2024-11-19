package finalpoo;

import java.util.List;

/**
 * Clase ModuloInscripcion
 * Gestiona el cálculo de indicadores escolares y la asignación de números de inscripción.
 */
public class ModuloInscripcion {

    /**
     * Procesa las inscripciones de los alumnos.
     * Ordena a los alumnos por su indicador escolar en orden descendente
     * utilizando un algoritmo burbuja y asigna números de inscripción consecutivos
     * empezando desde el 1.
     *
     * @param alumnos Lista de alumnos a inscribir.
     */
    public void procesarInscripciones(List<Alumno> alumnos) {
        // Ordenar alumnos manualmente usando el método burbuja
        for (int i = 0; i < alumnos.size() - 1; i++) {
            for (int j = 0; j < alumnos.size() - i - 1; j++) {
                // Comparar indicadores escolares
                if (alumnos.get(j).getIndicadorEscolar() < alumnos.get(j + 1).getIndicadorEscolar()) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    Alumno temp = alumnos.get(j);
                    alumnos.set(j, alumnos.get(j + 1));
                    alumnos.set(j + 1, temp);
                }
            }
        }

        // Asignar número de inscripción basado en el nuevo orden
        for (int i = 0; i < alumnos.size(); i++) {
            alumnos.get(i).setNumeroInscripcion(i + 1);
        }

        System.out.println("Números de inscripción asignados correctamente.");
    }
}
