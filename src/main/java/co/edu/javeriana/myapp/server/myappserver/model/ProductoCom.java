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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// Ver http://www.baeldung.com/role-and-privilege-for-spring-security-registration
@Entity
@Table(name="ProductoCom")
public class ProductoCom {
    private static final long serialVersionUID = 1987040876334251017L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int cantidad;

    @Column(unique=true)
    private String codigoSKU;

    private String nombre;
    private int precio;
    private int undMed;
    private Date fechaAdquisicion;
    private Date fechaVencimiento;

    //Constructor 

    public ProductoCom ( int cantidad, String codigoSKU, String nombre, 
                        int precio, int undMed, Date fechaAdquisicion,
                         Date fechaVencimiento)
    {
        this.cantidad = cantidad;
        this.codigoSKU = codigoSKU;
        this.nombre = nombre;
        this.precio = precio;
        this.undMed = undMed;
        this.fechaAdquisicion = fechaAdquisicion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public ProductoCom ()
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
  
      public Date getFechaAdquisicion()
      {
          return this.fechaAdquisicion;
      }

      public Date getFechaVencimiento()
      {
          return this.fechaVencimiento;
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
  
      public void setFechaAdquisicion(Date fechaAdquisicion) {
          this.fechaAdquisicion = fechaAdquisicion;
      }

      
      public void setFechaVencimiento(Date fechaVencimiento) {
          this.fechaVencimiento = fechaVencimiento;
      }
      @Override 
      public String toString()
      {
          Date fechaVencimiento2 = fechaVencimiento;
        return "Producto [cantidad: " + cantidad + ", codigoSKU: " + codigoSKU + ", nombre: " + nombre + ", precio: "
                + precio + ", undMed: " + undMed + ", fechaAdquisicion: " + fechaAdquisicion + ",fechaVencimiento: "
                + fechaVencimiento2 + " ]";
      }
}

