package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        ProductoInv p = productoInvRepository.findByCodigoSKU(codigoSKU);
        if (p.equals(null))
        {
            return null;
        }
        else{
            return p;
        }
    }

    @RequestMapping(value = "/producto/n/{nombre}")
    ProductoInv findByNombre(@PathVariable("nombre") String nombre)
    {
        
        ProductoInv p = productoInvRepository.findByNombre(nombre);
        if (p.equals(null))
        {
            return null;
        }
        else{
            return p;
        }
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
    ProductoInv crearProductoInv (@RequestBody ProductoInv producto)
    {
        return productoInvRepository.save(producto);
    }

    @PutMapping("/producto")
    ProductoInv updateProductoInv (@RequestBody ProductoInv producto)
    {      
        return productoInvRepository.save(producto);
    }

    @RequestMapping(value="/productos", method = RequestMethod.GET)
    @ResponseBody
    ProductoInv FilterByPrecio(@RequestParam(value="v1", required=true) int v1 ,@RequestParam(value="v2",required=true) int v2)
    {
        System.out.println("Llegaaaaaaaaaaaaaaaaaaaa");
        System.out.println(v1+"  "+v2);
        
        return productoInvRepository.FilterByPrecio(v1, v2);
    }
}