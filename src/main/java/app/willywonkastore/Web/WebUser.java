
package app.willywonkastore.Web; // Nombre del paquete en minusculas

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.willywonkastore.Model.User;
import app.willywonkastore.Service.ServiceUser;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE })
public class WebUser {

    @Autowired
    /**
     * Instansia de la clase ServiceUser
     *
     * @param WebUser in this space start code..
     */
    private ServiceUser servicios;

    @GetMapping("/all")
    /**
     * Metodo para listar usuarios
     *
     * @param Trae los usuarios que encuentre en la base de datos para listarlos
     *
     * *@return Lista de usuarios
     */
    public List<User> getUser() {
        return servicios.getAll();
    }

    @PostMapping("/new")
    /**
     * Metodo para crear un usuario.
     *
     * @param Se utiliza para crear usuarios y agregarlos a la base de datos.
     *
     * *@return el usuario.
     */
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return servicios.save(user);
    }

    @GetMapping("/{email}/{password}")
    /**
     * Metodo para autenticar el email y la contraseña.
     *
     * @param Se utiliza validar los parametros mencionados y dirigir a la Main, en caso de ser true..
     *
     * *@return true or false.
     */
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicios.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    /**
     * Metodo para validar si existe el correo ingresado en la DB.
     *
     * @param El email que se valida es el del login.
     *
     * *@return Si existe en la DB, retorna true, de lo contrario false.
     */
    public boolean existeEmail(@PathVariable("email") String email) {
        return servicios.existeEmail(email);
    }
}
