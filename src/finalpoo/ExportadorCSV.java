/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

/**
 * Clase ExportadorCSV
 * Permite exportar listas de alumnos a un archivo CSV.
 * 
 * Autor: Ivan Ocadiz
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase ExportadorCSV
 * Permite exportar la lista de alumnos a un archivo CSV.
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
            // Escribir la cabecera del archivo CSV
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
}