package finalpoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase GeneradorDeDatos
 * Proporciona métodos estáticos para generar datos aleatorios relacionados con alumnos,
 * como nombres, apellidos, edades, direcciones, créditos y asignaturas.
 * 
 * Esta clase es utilizada para simular datos de forma automática y dinámica
 * en el sistema de gestión de alumnos.
 * 
 * @author EquipoE
 */
public class GeneradorDeDatos {

    // **Atributos**
    /**
     * Generador de números aleatorios para las operaciones de generación.
     */
    private static final Random random = new Random();

    // **Métodos**

    /**
     * Genera un nombre completo aleatorio.
     * Combina un nombre y dos apellidos seleccionados aleatoriamente de listas predefinidas.
     * 
     * @return Un nombre completo generado aleatoriamente.
     */
    public static String generarNombreCompleto() {
        String[] nombres = {
            "Maia", "Ivan", "Sofia", "Eduardo", "Luis", "Hirono", "Pedro", "Lucia", "Miguel", "Carmen",
            "Jose", "Elena", "Ricardo", "Isabel", "Fernando", "Laura", "Francisco", "Valeria", "Manuel", "Paula",
            "Javier", "Julia", "Roberto", "Andrea", "Diego", "Gabriela", "Hector", "Diana", "Arturo", "Claudia",
            "Raul", "Lorena", "Sergio", "Patricia", "Alberto", "Victoria", "Pablo", "Monica", "Adrian", "Alejandra",
            "Mario", "Susana", "Guillermo", "Alicia", "Hugo", "Sara", "Eduardo", "Mariana", "Jorge", "Rosa"
        };

        String[] apellidos = {
            "Ocadiz", "Mejia", "Hernandez", "Camacho", "Garduño", "Peralta", "Sanchez", "Ramirez", "Torres", "Flores",
            "Rivera", "Alvarez", "Moreno", "Gomez", "Diaz", "Vargas", "Ortiz", "Ruiz", "Ramos", "Cruz",
            "Reyes", "Jimenez", "Castro", "Mendoza", "Romero", "Silva", "Delgado", "Guerrero", "Luna", "Dominguez",
            "Chavez", "Vega", "Suarez", "Soto", "Navarro", "Rojas", "Campos", "Peña", "Vargas", "Herrera",
            "Blanco", "Morales", "Alvarado", "Paredes", "Fuentes", "Espinoza", "Cortes", "Molina", "Velazquez", "Carrillo"
        };

        // Seleccionar un nombre y dos apellidos aleatoriamente
        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido1 = apellidos[random.nextInt(apellidos.length)];
        String apellido2 = apellidos[random.nextInt(apellidos.length)];

        return nombre + " " + apellido1 + " " + apellido2;
    }

    /**
     * Genera una dirección aleatoria a partir de un archivo de texto.
     * 
     * @param archivoDirecciones Ruta al archivo que contiene direcciones.
     * @return Una dirección seleccionada aleatoriamente del archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static String generarDireccion(String archivoDirecciones) throws IOException {
        List<String> direcciones = Files.readAllLines(Paths.get(archivoDirecciones));
        return direcciones.get(random.nextInt(direcciones.size()));
    }

    /**
     * Genera una edad aleatoria para un alumno, cumpliendo reglas específicas.
     * Asegura que los alumnos de 3er semestre no tengan 18 años.
     * 
     * @param semestre Semestre actual del alumno.
     * @return Una edad aleatoria entre 18 y 27, respetando las restricciones.
     */
    public static int generarEdad(int semestre) {
        int edad;
        do {
            edad = random.nextInt(10) + 18; // Generar edades entre 18 y 27
        } while (semestre == 3 && edad == 18); // Restricción para 3er semestre
        return edad;
    }

    /**
     * Genera un arreglo de créditos aleatorios para un número de asignaturas.
     * Garantiza que el total de créditos sea al menos 50.
     * 
     * @param numeroAsignaturas Número de asignaturas para las que se generarán créditos.
     * @return Un arreglo de créditos generado aleatoriamente.
     */
    public static int[] generarCreditos(int numeroAsignaturas) {
        int[] creditos = new int[numeroAsignaturas];
        int totalCreditos = 0;

        // Generar créditos aleatorios entre 1 y 4 para cada asignatura
        for (int i = 0; i < numeroAsignaturas; i++) {
            creditos[i] = random.nextInt(4) + 1;
            totalCreditos += creditos[i];
        }

        // Ajustar si el total es menor a 50
        if (totalCreditos < 50) {
            int diferencia = 50 - totalCreditos;
            int incrementoPorAsignatura = diferencia / numeroAsignaturas;
            int residuo = diferencia % numeroAsignaturas;

            for (int i = 0; i < numeroAsignaturas; i++) {
                creditos[i] += incrementoPorAsignatura;
                if (residuo > 0) {
                    creditos[i]++;
                    residuo--;
                }
            }
        }

        return creditos;
    }

    /**
     * Genera una lista de asignaturas con calificaciones y créditos aleatorios.
     * 
     * @param numeroAsignaturas Número de asignaturas a generar.
     * @return Lista de asignaturas generadas aleatoriamente.
     */
    public static List<Asignatura> generarAsignaturas(int numeroAsignaturas) {
        List<Asignatura> asignaturas = new ArrayList<>();

        // Generar asignaturas con calificaciones entre 50 y 100, y créditos entre 1 y 4
        for (int i = 0; i < numeroAsignaturas; i++) {
            double calificacion = random.nextDouble() * 50 + 50; // Calificación entre 50 y 100
            int creditos = random.nextInt(4) + 1; // Créditos entre 1 y 4
            asignaturas.add(new Asignatura(creditos, calificacion));
        }

        return asignaturas;
    }
}
