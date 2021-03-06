package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.javeriana.myapp.server.myappserver.model.ProductoCom;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoComRepository;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ProductoComService
{
    @Autowired
    private ProductoComRepository productoComRepository;
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/productoCom")
    Iterable<ProductoCom> findAll()
    {
        return productoComRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/productoCom/{id}")
    Optional<ProductoCom> findById(@PathVariable("id") Long id)
    {
        return productoComRepository.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/productoCom/c/{codigoSKU}")
    ProductoCom findByCodigoSKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        ProductoCom p = productoComRepository.findByCodigoSKU(codigoSKU);
        if (p.equals(null))
        {
            return null;
        }
        else{
            return p;
        }
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/productoCom/n/{nombre}")
    ProductoCom findByNombre(@PathVariable("nombre") String nombre)
    {
        ProductoCom p = productoComRepository.findByNombre(nombre);
        if (p.equals(null))
        {
            return null;
        }
        else{
            return p;
        }
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @DeleteMapping("/productoCom/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        productoComRepository.deleteById(id);
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @DeleteMapping("/productoCom/c/{codigoSKU}")
    void deleteBySKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        productoComRepository.deleteByCodigoSKU(codigoSKU);
    }

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @PostMapping("/productoCom")
    ProductoCom crearProductoCom (@RequestBody ProductoCom producto)
    {
        return productoComRepository.save(producto);
    }

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @PutMapping("/productoCom")
    ProductoCom updateProductoCom (@RequestBody ProductoCom producto)
    {
        return productoComRepository.save(producto);
    }
}