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
import javax.persistence.Table;

// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
@Table(name = "productoInv")
public class ProductoInv {
    private static final long serialVersionUID = 1987040876334251017L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String codigoSKU;
    private String nombre;
    private int precio;
    private int undMed;
    private int cantidad;
    

    //Constructor

    public ProductoInv ( int cantidad, String codigoSKU, String nombre, int precio, int undMed)
    {
        this.cantidad = cantidad;
        this.codigoSKU = codigoSKU;
        this.nombre = nombre;
        this.precio = precio;
        this.undMed = undMed;
    }

    public ProductoInv ()
    {

    }

    //Getters and Setters

    public int getId()
    {
        return this.id;
    }

    public int getCantidad()
    {
        return this.cantidad;
    }

    public String getCodigoSKU()
    {
        return this.codigoSKU;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public int getPrecio()
    {
        return this.precio;
    }

    public int getUndMed()
    {
        return this.undMed;
    }

    public void setCantidad (int cantidad)
    {
        this.cantidad = cantidad;
    }

    public void setCodigoSKU (String codigoSKU)
    {
        this.codigoSKU = codigoSKU;
    }

    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }

    public void setPrecio (int precio)
    {
        this.precio = precio;
    }

    public void setUndMed (int undMed)
    {
        this.undMed = undMed;
    }


    @Override 
    public String toString()
    {
        return "Producto [cantidad: "+ cantidad +", codigoSKU: "+ codigoSKU +", nombre: "+ nombre +", precio: "+ precio +", undMed: "+ undMed +" ]";
    }
}
