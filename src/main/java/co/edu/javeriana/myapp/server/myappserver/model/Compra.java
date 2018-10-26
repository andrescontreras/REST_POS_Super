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
    private Cliente cliente;
    private String fecha;
	private int total;
    @OneToMany (mappedBy="compra")
    private List<ProductoCom> productos;

    	

    //Constructor 
    public Compra(String fecha, int total, Cliente cliente )
    {
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        productos = new ArrayList<ProductoCom>();
    }

    public Compra ()
    {

    }

    //Add

    public void addCompra(ProductoCom p)
    {
        this.productos.add(p);
    }

    //Getters and Setters
    public Long getId()
    {
        return this.id;
    }

    public List<ProductoCom> getComprados()
    {
        return this.productos;
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
        this.productos = c;
    }
}