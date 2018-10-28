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
        return compraRepository.findAll();
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @RequestMapping("/compra/{id}")
    Optional<Compra> findById(@PathVariable("id") Long id)
    {
        return compraRepository.findById(id);
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @DeleteMapping("/compra/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        compraRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @PostMapping("/compra")
    Compra crearCompra (@RequestBody Compra compra)
    {
        System.out.print(compra.getComprados());
        List<ProductoCom> comprados = compra.getComprados();
        int descontar;
        int inventario;
        System.out.println(comprados.size());
        compra = compraRepository.save(compra);

        for (ProductoCom c : comprados)
        {
            descontar = c.getCantidad();
            ProductoInv i = inventarioRepository.findByCodigoSKU(c.getCodigoSKU());
            inventario = i.getCantidad();
            inventario = inventario - descontar;
            i.setCantidad(inventario);
            c.setCompra(compra);
            productoComRepository.save(c);
        }

        return compra;
        
    }
    
    @PreAuthorize("hasRole('ROLE_CAJERO')")
    @PutMapping("/compra")
    Compra updateCompra (@RequestBody Compra compra)
    {
        return compraRepository.save(compra);
    }
}