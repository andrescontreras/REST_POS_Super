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

    @Id
    private int id;
    private int cantidad;
    private int codigoSKU;
    private String nombre;
    private int precio;
    private int undMed;

    /*

    @OneToMany(mappedBy="items")
    private List<Item> items;
    
    public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCodigoSKU() {
		return codigoSKU;
	}
	public void setCodigoSKU(int codigoSKU) {
		this.codigoSKU = codigoSKU;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getUndMed() {
		return undMed;
	}
	public void setUndMed(int undMed) {
		this.undMed = undMed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}