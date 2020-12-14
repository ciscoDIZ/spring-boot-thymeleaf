package net.openwebinars.proyectothymeleaf.model;

import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import java.util.Objects;

public class User {
    @Min(value=0,message = "{user.id.mayorquecero}")
    private long id;
    @NotEmpty
    private String nombre;
    private String apellidos;
    @Email
    private String email;
    private String nombreUsuario;
    private String passwd;
    private String imagen;
    public User() {}

    public User(@Min(value = 0, message = "{user.id.mayorquecero}") long id,
                @NotEmpty String nombre,
                String apellidos,
                @Email String email,
                String nombreUsuario,
                String passwd,
                String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.passwd = passwd;
        this.imagen = imagen;
    }

    public User(@Min(value = 0, message = "{user.id.mayorquecero}") long id,
                @NotEmpty String nombre,
                String apellidos,
                @Email String email,
                String nombreUsuario,
                String passwd) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.passwd = passwd;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getNombre().equals(user.getNombre()) && getApellidos().equals(user.getApellidos()) && getEmail().equals(user.getEmail()) && getNombreUsuario().equals(user.getNombreUsuario()) && getPasswd().equals(user.getPasswd()) && Objects.equals(getImagen(), user.getImagen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApellidos(), getEmail(), getNombreUsuario(), getPasswd(), getImagen());
    }
}
