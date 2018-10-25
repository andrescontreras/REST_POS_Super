package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.Compra;
import co.edu.javeriana.myapp.server.myappserver.model.CompraRepository;
import java.util.Optional;


@RestController
public class CompraService
{
    @Autowired
    private CompraRepository compraRepository;

    @RequestMapping("/compra")
    Iterable<Compra> findAll()
    {
        return compraRepository.findAll();
    }

    @RequestMapping("/compra/{id}")
    Optional<Compra> findById(@PathVariable("id") Long id)
    {
        return compraRepository.findById(id);
    }

    @DeleteMapping("/compra/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        compraRepository.deleteById(id);
    }


    @PostMapping("/compra")
    Compra crearProductoInv (Compra compra)
    {
        return compraRepository.save(compra);
    }

    @PutMapping("/compra")
    Compra updateProductoInv (Compra compra)
    {
        return compraRepository.save(compra);
    }
}