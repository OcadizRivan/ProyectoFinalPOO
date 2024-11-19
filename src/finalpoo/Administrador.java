package finalpoo;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Administrador
 * Representa a un administrador del sistema, con capacidades de iniciar sesión
 * y gestionar alumnos en el sistema.
 * 
 * Autor: Ivan Ocadiz
 */

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
        usuarios.put("Ares", "GuauGuau");
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

}
