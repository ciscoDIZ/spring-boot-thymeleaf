package net.openwebinars.proyectothymeleaf.repositories;

import net.openwebinars.proyectothymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrNombreUsuarioContainsIgnoreCase(String nombre, String apellido, String nombreUsuario);
}
