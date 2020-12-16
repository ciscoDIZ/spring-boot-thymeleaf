package net.openwebinars.proyectothymeleaf.services;

import net.openwebinars.proyectothymeleaf.model.User;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;
import java.util.List;
public interface UserService {
  public User add(User user);
  public List<User> findAll();
  public User findById(long id);
  public User edit(User user);
  public void detele(User user);
}
