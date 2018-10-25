package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
@Table(name="Usuario")
public class Usuario {
    private static final long serialVersionUID = 1987040876334251017L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String usuario;
    private String password;
    private int tipo;

    //Constructor 

    public Usuario (String usuario, String password, int tipo)
    {
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
    }

    public Usuario()
    {

    }

    //Gettters and Setters

    public int getId()
    {
        return this.id;
    }

    public String getUsuario()
    {
        return this.usuario;
    }

    public String getPassword()
    {
        return this.password;
    }

    public int getTipo()
    {
        return this.tipo;
    }

    public void setuUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTipo(int tipo)
    {
        this.tipo = tipo;
    }

}
