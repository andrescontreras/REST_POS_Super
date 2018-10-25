package co.edu.javeriana.myapp.server.myappserver.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
@Table(name="compra")
public class Compra {
    private static final long serialVersionUID = 1987040876334251017L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date fecha;
	private int total;	

    //Constructor 
    public Compra(Date fecha, int total )
    {
        this.fecha = fecha;
        this.total = total;
    }

    public Compra ()
    {

    }

    //Getters and Setters
    public int getId()
    {
        return this.id;
    }

    public Date getFecha()
    {
        return this.fecha;
    }

    public int getTotal()
    {
        return this.total;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public void setTotal (int total)
    {
        this.total = total;
    }
}