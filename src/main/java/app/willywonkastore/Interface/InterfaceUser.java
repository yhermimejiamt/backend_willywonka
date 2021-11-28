
package app.willywonkastore.Interface;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.willywonkastore.Model.User;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceUser extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
    
}
