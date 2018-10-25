package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.javeriana.myapp.server.myappserver.model.ProductoInv;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInvRepository;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ProductoInvService
{
    @Autowired
    private ProductoInvRepository productoInvRepository;

    @RequestMapping("/producto")
    Iterable<ProductoInv> findAll()
    {
        return productoInvRepository.findAll();
    }

    @RequestMapping("/producto/{id}")
    Optional<ProductoInv> findById(@PathVariable("id") Long id)
    {
        return productoInvRepository.findById(id);
    }

    @RequestMapping("/producto/{codigoSKU}")
    Optional<ProductoInv> findByCodigoSKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        return productoInvRepository.findByCodigoSKU(codigoSKU);
    }

    @DeleteMapping("/producto/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        productoInvRepository.deleteById(id);
    }

    @DeleteMapping("/producto/{codigoSKU}")
    void deleteBySKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        productoInvRepository.deleteByCodigoSKU(codigoSKU);
    }

    @PostMapping("/producto")
    ProductoInv crearProductoInv (ProductoInv producto)
    {
        return productoInvRepository.save(producto);
    }

    @PutMapping("/producto")
    ProductoInv updateProductoInv (ProductoInv producto)
    {
        return productoInvRepository.save(producto);
    }
}