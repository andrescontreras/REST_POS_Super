package co.edu.javeriana.myapp.server.myappserver.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
@Table(name="compra")
public class Compra {
    private static final long serialVersionUID = 1987040876334251017L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    @JsonBackReference
    private Cliente cliente;

    @OneToMany (mappedBy="compra")
    @JsonManagedReference
    private List<ProductoCom> comprados;

    private String fecha;
	private int total;	

    //Constructor 
    public Compra(String fecha, int total, Cliente cliente )
    {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.comprados = new ArrayList<>();
    }

    public Compra(String fecha, int total,  Cliente cliente, ArrayList<ProductoCom> comprados )
    {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.comprados = comprados;
    }

    public Compra ()
    {

    }

    //Add

    public void addCompra(ProductoCom p)
    {
        this.comprados.add(p);
    }

    //Getters and Setters
    public Long getId()
    {
        return this.id;
    }

    public List<ProductoCom> getComprados()
    {
        return this.comprados;
    }

    public String getFecha()
    {
        return this.fecha;
    }

    public int getTotal()
    {
        return this.total;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public void setTotal (int total)
    {
        this.total = total;
    }

    public void setCliente (Cliente cliente)
    {
        this.cliente = cliente;
    }

    public void setComprados( List<ProductoCom> c)
    {
        this.comprados = c;
    }
}