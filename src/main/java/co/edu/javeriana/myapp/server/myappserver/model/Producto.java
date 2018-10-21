package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
public class Producto {
    private static final long serialVersionUID = 1987040876334251017L;


    @OneToMany(mappedBy="items")
    private List<Item> items;
    
    @Id
    private int id;
    private int cantidad;
    private int codigoSKU;
    private String nombre;
    private int precio;
    private int undMed;
}
