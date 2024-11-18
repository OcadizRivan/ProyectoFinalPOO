/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

/**
 * Clase GeneradorDeDatos
 * Genera datos aleatorios para los alumnos, como nombres, apellidos, edades y direcciones.
 * 
 * Autor: Ivan Ocadiz
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase GeneradorDeDatos
 * Proporciona métodos estáticos para generar datos aleatorios utilizados en el sistema.
 */
public class GeneradorDeDatos {

    private static final Random random = new Random();

    /**
     * Genera un nombre completo aleatorio.
     * @return Un nombre completo con nombres y apellidos seleccionados aleatoriamente.
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


        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido1 = apellidos[random.nextInt(apellidos.length)];
        String apellido2 = apellidos[random.nextInt(apellidos.length)];

        return nombre + " " + apellido1 + " " + apellido2;
    }


    /**
     * Genera una dirección aleatoria a partir de un archivo.
     * @param archivoDirecciones Ruta al archivo de texto con direcciones.
     * @return Una dirección seleccionada aleatoriamente del archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static String generarDireccion(String archivoDirecciones) throws IOException {
        List<String> direcciones = Files.readAllLines(Paths.get(archivoDirecciones));
        return direcciones.get(random.nextInt(direcciones.size()));
    }

    /**
     * Genera una edad aleatoria para un alumno, asegurando que las reglas de edad se cumplan.
     * @param semestre Semestre del alumno.
     * @return Una edad aleatoria entre 18 y 27, respetando las restricciones.
     */
    public static int generarEdad(int semestre) {
        int edad;
        do {
            edad = random.nextInt(10) + 18; // Edades entre 18 y 27
        } while (semestre == 5 && edad == 18); // Un alumno de 5to semestre no puede tener 18 años
        return edad;
    }

    /**
     * Genera un arreglo de créditos aleatorios para un número de asignaturas.
     * Se asegura de que el total de créditos sea al menos 50.
     * @param numeroAsignaturas Número de asignaturas.
     * @return Arreglo de créditos generados.
     */
    public static int[] generarCreditos(int numeroAsignaturas) {
        int[] creditos = new int[numeroAsignaturas];
        int totalCreditos = 0;

        for (int i = 0; i < numeroAsignaturas; i++) {
            creditos[i] = random.nextInt(4) + 1; // Créditos entre 1 y 4
            totalCreditos += creditos[i];
        }

        // Asegurar que el total sea al menos 50
        if (totalCreditos < 50) {
            creditos[0] += (50 - totalCreditos); // Ajustar la primera asignatura
        }

        return creditos;
    }

    /**
     * Genera una lista de asignaturas con calificaciones y créditos aleatorios.
     * @param numeroAsignaturas Número de asignaturas a generar.
     * @return Lista de asignaturas generadas.
     */
    public static List<Asignatura> generarAsignaturas(int numeroAsignaturas) {
        List<Asignatura> asignaturas = new ArrayList<>();

        for (int i = 0; i < numeroAsignaturas; i++) {
            double calificacion = random.nextDouble() * 50 + 50; // Calificaciones entre 50 y 100
            int creditos = random.nextInt(4) + 1; // Créditos entre 1 y 4
            asignaturas.add(new Asignatura(creditos, calificacion));
        }

        return asignaturas;
    }
}
