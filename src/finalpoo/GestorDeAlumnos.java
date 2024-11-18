/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

/**
 * Clase GestorDeAlumnos
 * Permite gestionar el CRUD de alumnos en el sistema.
 * 
 * Autor: Ivan Ocadiz
 */

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class GestorDeAlumnos {

    // Lista para almacenar los alumnos
    private List<Alumno> alumnos;

    // Constructor
    public GestorDeAlumnos() {
        this.alumnos = new ArrayList<>();
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
            alumnos.remove(alumnoExistente);
            alumnos.add(nuevoAlumno);
            System.out.println("Alumno actualizado exitosamente.");
        }
    }

    /**
     * Elimina un alumno del sistema.
     * @param numeroCuenta El número de cuenta del alumno a eliminar.
     */
    public void eliminarAlumno(String numeroCuenta) {
        Alumno alumno = buscarAlumno(numeroCuenta);
        if (alumno != null) {
            alumnos.remove(alumno);
            System.out.println("Alumno eliminado exitosamente.");
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
                System.out.println(alumno);
            }
        }
    }

    /**
     * Carga una lista de alumnos desde un archivo CSV.
     * @param archivoCSV Ruta del archivo CSV.
     */
    public void cargarDesdeCSV(String archivoCSV) {
        alumnos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false; // Saltar la cabecera
                    continue;
                }

                String[] datos = linea.split(",");

                // Leer los datos del archivo CSV
                String numeroCuenta = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String direccion = datos[3];
                int edad = Integer.parseInt(datos[4]);
                int semestre = Integer.parseInt(datos[5]);
                int totalCreditos = Integer.parseInt(datos[6]);
                double promedio = Double.parseDouble(datos[7]);
                double escolaridad = Double.parseDouble(datos[8]);
                double velocidad = Double.parseDouble(datos[9]);
                double indicadorEscolar = Double.parseDouble(datos[10]);
                int numeroInscripcion = Integer.parseInt(datos[11]);

                // Crear un objeto Alumno
                Alumno alumno = new Alumno(numeroCuenta, nombre, apellido, direccion, edad, semestre, new int[] {});
                alumno.setTotalCreditos(totalCreditos);
                alumno.setPromedio(promedio);
                alumno.setEscolaridad(escolaridad);
                alumno.setVelocidad(velocidad);
                alumno.setIndicadorEscolar(indicadorEscolar);
                alumno.setNumeroInscripcion(numeroInscripcion);

                // Agregar el alumno a la lista
                alumnos.add(alumno);
            }
            System.out.println("Archivo CSV cargado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }
    }

    /**
     * Exporta la lista de alumnos a un archivo CSV.
     * @param archivoCSV Ruta del archivo CSV.
     */
    public void exportarACSV(String archivoCSV) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoCSV))) {
            bw.write("NumeroCuenta,Nombre,Apellido,Direccion,Edad,Semestre,TotalCreditos,Promedio,Escolaridad,Velocidad,IndicadorEscolar,NumeroInscripcion");
            bw.newLine();

            for (Alumno alumno : alumnos) {
                bw.write(String.format("%s,%s,%s,%s,%d,%d,%d,%.2f,%.2f,%.2f,%.2f,%d",
                        alumno.getNumeroCuenta(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        alumno.getDireccion(),
                        alumno.getEdad(),
                        alumno.getSemestre(),
                        alumno.getTotalCreditos(),
                        alumno.getPromedio(),
                        alumno.getEscolaridad(),
                        alumno.getVelocidad(),
                        alumno.getIndicadorEscolar(),
                        alumno.getNumeroInscripcion()));
                bw.newLine();
            }
            System.out.println("Archivo CSV exportado exitosamente a: " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }

    // Getters y Setters

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
