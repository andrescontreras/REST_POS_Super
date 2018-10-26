
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Table;
// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
@Table(name = "Cliente")
public class Cliente {
    private static final long serialVersionUID = 1987040876334251017L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @OneToMany(mappedBy="cliente")
    private List<Compra> compras; 

    @Column(name = "identificacion", unique=true, nullable = false)
    private int identificacion;
    
    @Column(name = "nombre")
	private String nombre;	


    //Constructor

    public Cliente (int identificacion, String nombre)
    {
        this.identificacion = identificacion;
        this.nombre = nombre;
        compras = new ArrayList<Compra>();
    }

    public Cliente ()
    {

    }

    //Add

    public void addCompra(Compra compra)
    {
        this.compras.add(compra);
    }
    //Getters and Setters

    public Long getId()
    {
        return this.id;
    }

    public int getIdentificacion()
    {
        return this.identificacion;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public List<Compra> getCompras()
    {
        return this.compras;
    }

    public void setIdentificacion(int identificacion)
    {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setCompras(List<Compra> compras)
    {
        this.compras = compras;
    }
}
