
package app.willywonkastore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.willywonkastore.Model.User;
import app.willywonkastore.Repository.RepositoryUser;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser metodosCrud;

    public List<User> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<User> getUser(int id) {
        return metodosCrud.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return metodosCrud.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return metodosCrud.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = metodosCrud.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            // throw new Error();
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
