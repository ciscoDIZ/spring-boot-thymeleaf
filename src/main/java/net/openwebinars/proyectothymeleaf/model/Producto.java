package net.openwebinars.proyectothymeleaf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Producto {
    @Id
    private long id;

    @ManyToOne
    private Categoria categoria;
}
