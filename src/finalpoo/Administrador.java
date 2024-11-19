package finalpoo;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Administrador
 * Representa a un administrador del sistema, con capacidades de iniciar sesión
 * y gestionar alumnos en el sistema.
 * 
 * Esta clase permite manejar usuarios administrativos mediante un mapa 
 * que almacena nombres de usuario y contraseñas. Proporciona funcionalidad
 * para verificar credenciales en el inicio de sesión.
 * 
 * @author EquipoE
 */
public class Administrador {

    // **Atributos**
    /**
     * Mapa que almacena los usuarios y sus contraseñas.
     */
    private Map<String, String> usuarios;

    // **Constructor**
    /**
     * Constructor de la clase Administrador.
     * Inicializa el mapa de usuarios con credenciales predeterminadas.
     */
    public Administrador() {
        this.usuarios = new HashMap<>();
        // Agregar usuarios predeterminados al sistema
        usuarios.put("Maia", "1710");
        usuarios.put("Ivan", "2608");
        usuarios.put("Profesor", "losapruebocon10");
        usuarios.put("Admin", "1234");
    }

    // **Métodos**
    /**
     * Verifica las credenciales de un usuario para iniciar sesión.
     * 
     * @param inputUsername Nombre de usuario ingresado por el administrador.
     * @param inputPassword Contraseña ingresada por el administrador.
     * @return `true` si el nombre de usuario y la contraseña coinciden,
     *         `false` en caso contrario.
     */
    public boolean iniciarSesion(String inputUsername, String inputPassword) {
        return usuarios.containsKey(inputUsername) && usuarios.get(inputUsername).equals(inputPassword);
    }

}
