package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @RequestMapping("/productoInv")
    Iterable<ProductoCom> findAll()
    {
        return productoComRepository.findAll();
    }

    @RequestMapping("/productoCom/{id}")
    Optional<ProductoCom> findById(@PathVariable("id") Long id)
    {
        return productoComRepository.findById(id);
    }

    @RequestMapping("/productoCom/{codigoSKU}")
    Optional<ProductoCom> findByCodigoSKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        return productoComRepository.findByCodigoSKU(codigoSKU);
    }

    @DeleteMapping("/productoCom/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        productoComRepository.deleteById(id);
    }

    @DeleteMapping("/productoCom/{codigoSKU}")
    void deleteBySKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        productoComRepository.deleteByCodigoSKU(codigoSKU);
    }

    @PostMapping("/productoCom")
    ProductoCom crearProductoCom (ProductoCom producto)
    {
        return productoComRepository.save(producto);
    }

    @PutMapping("/productoCom")
    ProductoCom updateProductoCom (ProductoCom producto)
    {
        return productoComRepository.save(producto);
    }
}