
package app.willywonkastore.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.willywonkastore.Interface.InterfaceUser;
import app.willywonkastore.Model.User;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class RepositoryUser {

    @Autowired
    private InterfaceUser crud;

    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    public Optional<User> getUser(int id) {
        return crud.findById(id);
    }

    public User save(User user) {
        return crud.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = crud.findByEmail(email);
        if (usuario.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
}
