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

import co.edu.javeriana.myapp.server.myappserver.model.Compra;
import co.edu.javeriana.myapp.server.myappserver.model.CompraRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoCom;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoComRepository;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInv;
import co.edu.javeriana.myapp.server.myappserver.model.ProductoInvRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class CompraService
{
    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoInvRepository inventarioRepository;
    
    

    @Autowired
    private ProductoComRepository productoComRepository;

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping(value = "/compra", produces="application/json")
    Iterable<Compra> findAll()
    {
    	System.out.println("Estoy en findAll");
        return compraRepository.findAll();
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/compra/{id}")
    Optional<Compra> findById(@PathVariable("id") Long id)
    {
    	System.out.println("Estoy en findById");
        return compraRepository.findById(id);
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @DeleteMapping("/compra/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
    	System.out.println("Estoy en deleteById");
        compraRepository.deleteById(id);
    }

    @PostMapping("/compra/crear")
    Compra crearCompra (@RequestBody Compra compra)
    {
    	System.out.println("Estoy en crearCompra");
        System.out.print(compra.getComprados());
        List<ProductoCom> comprados = compra.getComprados();
        int descontar;
        int inventario;
        System.out.println("Tamano de comprados "+comprados.size());
        System.out.println(comprados.size());
        System.out.println("---------------------------------------------------");
        compra = compraRepository.save(compra);

        for (ProductoCom c : comprados)
        {
        	System.out.println("Comprados " +c.getNombre());
            descontar = c.getCantidad();
            System.out.println("Descontar " +descontar);
            ProductoInv i = inventarioRepository.findByCodigoSKU(c.getCodigoSKU());
            inventario = i.getCantidad();
            inventario = inventario - descontar;
            i.setCantidad(inventario);
            c.setCompra(compra);
            productoComRepository.save(c);
        }
        System.out.println("---------------------------------------------------");
        return compra;
        
    }
    
    //@PreAuthorize("hasRole('ROLE_CAJERO')")
    @PutMapping("/compra")
    Compra updateCompra (@RequestBody Compra compra)
    {
        List<ProductoCom> comprados = compra.getComprados();
        compra = compraRepository.save(compra);

        for (ProductoCom c : comprados)
        {
            c.setCompra(compra);
            productoComRepository.save(c);
        }

        return compra;
    }
}