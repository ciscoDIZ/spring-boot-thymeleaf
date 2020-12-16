package net.openwebinars.proyectothymeleaf.services;

import net.openwebinars.proyectothymeleaf.model.User;
import net.openwebinars.proyectothymeleaf.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Primary
@Service("userServiceDB")
public class UserServiceDB implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User edit(User user) {
        return repository.save(user);
    }

    @Override
    public void detele(User user) {
        repository.delete(user);
    }

    public List<User> buscador(String cadena){
        return repository.findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrNombreUsuarioContainsIgnoreCase(cadena,cadena,cadena);
    }
}
