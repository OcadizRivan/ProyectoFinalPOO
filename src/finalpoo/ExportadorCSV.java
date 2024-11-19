package finalpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase ExportadorCSV
 * Permite exportar listas de alumnos a un archivo CSV.
 * 
 * Autor: Ivan Ocadiz
 */
public class ExportadorCSV {

    /**
     * Exporta una lista de alumnos a un archivo CSV.
     * 
     * @param alumnos Lista de alumnos a exportar.
     * @param rutaArchivo Ruta del archivo CSV donde se exportarán los datos.
     */
    public void exportarAlumnos(List<Alumno> alumnos, String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribir la primera línea del archivo CSV
            writer.write("NumeroCuenta,Nombre,Apellido,Direccion,Edad,Semestre,TotalCreditos,Promedio,Escolaridad,Velocidad,IndicadorEscolar,NumeroInscripcion");
            writer.newLine();

            // Escribir los datos de cada alumno
            for (Alumno alumno : alumnos) {
                writer.write(String.format("%s,%s,%s,%s,%d,%d,%d,%.2f,%.2f,%.2f,%.2f,%d",
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
                writer.newLine();
            }

            System.out.println("Archivo CSV exportado exitosamente a: " + rutaArchivo);

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de alumnos desde un archivo CSV.
     * @param archivoCSV Ruta del archivo CSV.
     * @param alumnos Lista donde se cargarán los alumnos.
     */
    public void cargarDesdeCSV(String archivoCSV, List<Alumno> alumnos) {
        alumnos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false; // Saltar la primera línea
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
}