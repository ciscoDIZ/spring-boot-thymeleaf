package net.openwebinars.proyectothymeleaf.services;

import net.openwebinars.proyectothymeleaf.model.User;
import net.openwebinars.proyectothymeleaf.upload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service("userServiceMemory")
public class UserServiceMemory {

    private Set<User> repository;
    @Autowired
    private StorageService storageService;

    public UserServiceMemory() {
        this.repository = new HashSet<>();
    }

    public User add(User user){
        repository.add(user);
        return user;
    }

    public List<User> findAll(){
        List<User> resultado =new ArrayList<>(repository);
        return resultado.stream().sorted(Comparator.comparingInt(user -> (int) user.getId())).collect(Collectors.toList());
    }

    public User findById(long id){
        return repository.stream().filter(f-> f.getId() == id).findFirst().orElse(null);
    }

    @PostConstruct
    public void init(){
        repository.addAll(Arrays.asList(new User(1,
                "Juanito",
                "de los Palotes Almeida",
                "juanitopalotesalm@gmail.com",
                "juanpalote",
                "12345678"),
                new User(2,
                        "Pedrito",
                        "Juanes Suarez",
                        "pedritojuansua@gmail.com",
                        "pedrodinamita",
                        "12345678"),
                new User(3,
                        "Octavio",
                        "Magallanes Guevara",
                        "octamagavara@gmail.com",
                        "octatatata",
                        "12345678")));
    }

    public Set<User> getRepository() {
        return repository;
    }

    public void setRepository(Set<User> repository) {
        this.repository = repository;
    }
}
