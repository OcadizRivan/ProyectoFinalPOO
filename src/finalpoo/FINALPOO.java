package finalpoo;

import java.io.IOException;
import java.util.Scanner;


/**
 * Clase principal del sistema de gestión escolar.
 * 
 * Autor: Ivan Ocadiz
 */
public class FINALPOO {
    public static void main(String[] args) {
        // Crear el gestor de alumnos, administrador y módulos necesarios
        GestorDeAlumnos gestor = new GestorDeAlumnos();
        Administrador administrador = new Administrador();
        ModuloInscripcion moduloInscripcion = new ModuloInscripcion();
        ExportadorCSV exportadorCSV = new ExportadorCSV();

        // Crear 1000 alumnos al iniciar el programa
        System.out.println("Generando 1000 alumnos...");
        String rutaArchivoDirecciones = "/Users/ivanos/Downloads/direcciones.txt";

        for (int i = 1; i <= 1000; i++) {
            try {
                String numeroCuenta = String.format("FIUNAM%04d", i);
                String nombreCompleto = GeneradorDeDatos.generarNombreCompleto();
                String[] partesNombre = nombreCompleto.split(" ", 2);
                String nombre = partesNombre[0];
                String apellido = partesNombre.length > 1 ? partesNombre[1] : "";
                String direccion = GeneradorDeDatos.generarDireccion(rutaArchivoDirecciones);
                int semestre = (i % 10) + 1; // Semestre del 1 al 10
                int edad = GeneradorDeDatos.generarEdad(semestre);
                int[] creditos = GeneradorDeDatos.generarCreditos(5);

                Alumno nuevoAlumno = new Alumno(numeroCuenta, nombre, apellido, direccion, edad, semestre, creditos);
                gestor.agregarAlumno(nuevoAlumno);
            } catch (IOException e) {
                System.out.println("Error al generar alumnos: " + e.getMessage());
                break; // Detener la generación si ocurre un error
            }
        }
        System.out.println("1000 alumnos generados exitosamente.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Sistema de Gestión Escolar");
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        // Validar inicio de sesión
        if (!administrador.iniciarSesion(username, password)) {
            System.out.println("Datos de inicio de sesión incorrectos. Saliendo del sistema.");
            scanner.close();
            return;
        }

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Cargar Archivo CSV");
            System.out.println("2. Ver lista de alumnos");
            System.out.println("3. Crear Alumno");
            System.out.println("4. Leer Alumno");
            System.out.println("5. Actualizar Alumno");
            System.out.println("6. Eliminar Alumno");
            System.out.println("7. Generar número de inscripción");
            System.out.println("8. Exportar a CSV");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ruta del archivo CSV: ");
                    String rutaCSV = scanner.nextLine();
                    exportadorCSV.cargarDesdeCSV(rutaCSV, gestor.getAlumnos());
                    break;
                case 2:
                    gestor.mostrarAlumnos();
                    break;
                case 3:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el semestre: ");
                    int semestre = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea

                    int[] creditos = GeneradorDeDatos.generarCreditos(5);
                    Alumno nuevoAlumno = new Alumno(numeroCuenta, nombre, apellido, direccion, edad, semestre, creditos);
                    gestor.agregarAlumno(nuevoAlumno);
                    break;
                case 4:
                    System.out.print("Ingrese el número de cuenta del alumno: ");
                    String cuentaBusqueda = scanner.nextLine();
                    Alumno encontrado = gestor.buscarAlumno(cuentaBusqueda);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el número de cuenta del alumno a actualizar: ");
                    String cuentaActualizar = scanner.nextLine();
                    Alumno alumnoExistente = gestor.buscarAlumno(cuentaActualizar);
                    if (alumnoExistente != null) {
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo apellido: ");
                        String nuevoApellido = scanner.nextLine();
                        System.out.print("Ingrese la nueva dirección: ");
                        String nuevaDireccion = scanner.nextLine();
                        System.out.print("Ingrese la nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        System.out.print("Ingrese el nuevo semestre: ");
                        int nuevoSemestre = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea

                        int[] nuevosCreditos = GeneradorDeDatos.generarCreditos(5);
                        Alumno nuevoAlumnoDatos = new Alumno(cuentaActualizar, nuevoNombre, nuevoApellido, nuevaDireccion, nuevaEdad, nuevoSemestre, nuevosCreditos);
                        gestor.actualizarAlumno(cuentaActualizar, nuevoAlumnoDatos);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el número de cuenta del alumno a eliminar: ");
                    String cuentaEliminar = scanner.nextLine();
                    gestor.eliminarAlumno(cuentaEliminar);
                    break;
                case 7:
                    if (gestor.getAlumnos().isEmpty()) {
                        System.out.println("No hay alumnos registrados para procesar inscripciones.");
                    } else {
                        moduloInscripcion.procesarInscripciones(gestor.getAlumnos());
                        System.out.println("Números de inscripción generados exitosamente.");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese la ruta donde exportar el archivo CSV (incluyendo el nombre y la extensión): ");
                    String exportarRutaCSV = scanner.nextLine();
                    exportadorCSV.exportarAlumnos(gestor.getAlumnos(), exportarRutaCSV);
                    break;
                case 9:
                    System.out.println("Saliendo del sistema. Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
