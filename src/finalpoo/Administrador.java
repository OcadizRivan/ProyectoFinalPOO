/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalpoo;

/**
 * Clase Administrador
 * Representa a un administrador del sistema, con capacidades de iniciar sesión
 * y gestionar alumnos en el sistema.
 * 
 * Autor: Ivan Ocadiz
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Administrador {

    // Atributos
    private Map<String, String> usuarios; // Mapa de usuarios y contraseñas

    // Constructor
    public Administrador() {
        this.usuarios = new HashMap<>();
        // Agregar usuarios predeterminados
        usuarios.put("MaiaHeme", "princesa");
        usuarios.put("Mariana", "polloloco");
        usuarios.put("Sofia", "dragondecobre");
    }

    // Métodos

    /**
     * Verifica las credenciales de un usuario.
     * @param inputUsername Nombre de usuario ingresado.
     * @param inputPassword Contraseña ingresada.
     * @return true si las credenciales coinciden, false en caso contrario.
     */
    public boolean iniciarSesion(String inputUsername, String inputPassword) {
        return usuarios.containsKey(inputUsername) && usuarios.get(inputUsername).equals(inputPassword);
    }

    /**
     * Agrega un nuevo usuario al sistema.
     * @param username Nombre de usuario.
     * @param password Contraseña.
     */
    public void agregarUsuario(String username, String password) {
        usuarios.put(username, password);
        System.out.println("Usuario agregado exitosamente.");
    }

    /**
     * Elimina un usuario del sistema.
     * @param username Nombre de usuario a eliminar.
     */
    public void eliminarUsuario(String username) {
        if (usuarios.containsKey(username)) {
            usuarios.remove(username);
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Muestra el menú principal para gestionar alumnos.
     */
    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión escolar.");
        System.out.println("1. Generar lista de 1000 alumnos");
        System.out.println("2. Ver lista de alumnos");
        System.out.println("3. Crear alumno manualmente");
        System.out.println("4. Leer alumno");
        System.out.println("5. Actualizar alumno");
        System.out.println("6. Eliminar alumno");
        System.out.println("7. Agregar usuario");
        System.out.println("8. Eliminar usuario");
        System.out.println("9. Salir");
    }

    /**
     * Procesa la opción seleccionada por el administrador.
     * @param opcion Opción seleccionada del menú.
     * @param gestor Gestor de alumnos para manejar las operaciones.
     */
    public void procesarOpcion(int opcion, GestorDeAlumnos gestor) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Generando lista de 1000 alumnos...");
                for (int i = 1; i <= 1000; i++) {
                    String numeroCuenta = String.format("A%04d", i);
                    String nombreCompleto = GeneradorDeDatos.generarNombreCompleto();
                    String[] partesNombre = nombreCompleto.split(" ", 2);
                    String nombre = partesNombre[0];
                    String apellido = partesNombre.length > 1 ? partesNombre[1] : "";
                    String direccion;
                    try {
                        direccion = GeneradorDeDatos.generarDireccion("direcciones.txt");
                    } catch (IOException e) {
                        direccion = "Dirección genérica";
                    }
                    int semestre = (i % 10) + 1; // Semestre del 1 al 10
                    int edad = GeneradorDeDatos.generarEdad(semestre);
                    Alumno nuevoAlumno = new Alumno(numeroCuenta, nombre, apellido, direccion, edad, semestre, new double[0], new int[0], 0);
                    gestor.agregarAlumno(nuevoAlumno);
                }
                System.out.println("Lista de 1000 alumnos generada exitosamente.");
                break;
            case 2:
                System.out.println("Mostrando lista de alumnos...");
                gestor.mostrarAlumnos();
                break;
            case 3:
                System.out.println("Creando un nuevo alumno...");
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

                Alumno nuevoAlumno = new Alumno(numeroCuenta, nombre, apellido, direccion, edad, semestre, new double[0], new int[0], 0);
                gestor.agregarAlumno(nuevoAlumno);
                break;
            case 4:
                System.out.println("Leyendo datos de un alumno...");
                System.out.print("Ingrese el número de cuenta del alumno: ");
                String cuentaBusqueda = scanner.nextLine();
                Alumno encontrado = gestor.buscarAlumno(cuentaBusqueda);
                if (encontrado != null) {
                    System.out.println(encontrado);
                }
                break;
            case 5:
                System.out.println("Actualizando datos de un alumno...");
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

                    Alumno nuevoAlumnoDatos = new Alumno(cuentaActualizar, nuevoNombre, nuevoApellido, nuevaDireccion, nuevaEdad, nuevoSemestre, new double[0], new int[0], 0);
                    gestor.actualizarAlumno(cuentaActualizar, nuevoAlumnoDatos);
                }
                break;
            case 6:
                System.out.println("Eliminando datos de un alumno...");
                System.out.print("Ingrese el número de cuenta del alumno a eliminar: ");
                String cuentaEliminar = scanner.nextLine();
                gestor.eliminarAlumno(cuentaEliminar);
                break;
            case 7:
                System.out.print("Ingrese el nuevo nombre de usuario: ");
                String nuevoUsuario = scanner.nextLine();
                System.out.print("Ingrese la contraseña para el nuevo usuario: ");
                String nuevaContraseña = scanner.nextLine();
                agregarUsuario(nuevoUsuario, nuevaContraseña);
                break;
            case 8:
                System.out.print("Ingrese el nombre del usuario a eliminar: ");
                String usuarioEliminar = scanner.nextLine();
                eliminarUsuario(usuarioEliminar);
                break;
            case 9:
                System.out.println("Saliendo del sistema. Hasta pronto.");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }
}
