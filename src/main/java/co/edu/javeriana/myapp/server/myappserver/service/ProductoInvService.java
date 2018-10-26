package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    
    @RequestMapping(value = "/producto/c/{codigoSKU}")
    ProductoInv findByCodigoSKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        return productoInvRepository.findByCodigoSKU(codigoSKU);
    }

    @RequestMapping(value = "/producto/n/{nombre}")
    ProductoInv findByNombre(@PathVariable("nombre") String nombre)
    {
        System.out.println(nombre);
        return productoInvRepository.findByNombre(nombre);
    }

    @DeleteMapping("/producto/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        productoInvRepository.deleteById(id);
    }
    
    @DeleteMapping("/producto/c/{codigoSKU}")
    void deleteByCodigoSKU(@PathVariable("codigoSKU") String codigoSKU)
    {
        productoInvRepository.deleteByCodigoSKU(codigoSKU);
    }

    @DeleteMapping("/producto/n/{nombre}")
    void deleteByNombre(@PathVariable("nombre") String nombre)
    {
        productoInvRepository.deleteByNombre(nombre);
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

    @RequestMapping(value="/productos")
    @ResponseBody
    Optional<ProductoInv> FilterByPrecio(@RequestParam("v1") int v1,@RequestParam("v2") int v2)
    {
        return productoInvRepository.FilterByPrecio(v1, v2);
    }
}