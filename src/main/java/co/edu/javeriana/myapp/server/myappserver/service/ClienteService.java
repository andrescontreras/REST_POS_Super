package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.Cliente;
import co.edu.javeriana.myapp.server.myappserver.model.ClienteRepository;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping("/cliente")
    Iterable<Cliente> findAll()
    {
        return clienteRepository.findAll();
    }

    @RequestMapping("/cliente/{id}")
    Optional<Cliente> findById(@PathVariable("id") Long id)
    {
        return clienteRepository.findById(id);
    }

    @RequestMapping("/cliente/i/{identificacion}")
    Optional<Cliente> findByIdentificacion(@PathVariable("identificacion") int identificacion)
    {
        return clienteRepository.findByIdentificacion(identificacion);
    }

    @RequestMapping("/cliente/n/{nombre}")
    Optional<Cliente> findByNombre(@PathVariable("nombre") String nombre)
    {
        return clienteRepository.findByNombre(nombre);
    }

    @DeleteMapping("/cliente/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        clienteRepository.deleteById(id);
    }
    
    @DeleteMapping("/cliente/i/{identificacion}")
    void deleteBySKU(@PathVariable("identificacion") int identificacion)
    {
        clienteRepository.deleteByIdentificacion(identificacion);
    }

    @DeleteMapping("/cliente/n/{nombre}")
    void deleteByName(@PathVariable("nombre") String nombre)
    {
        clienteRepository.deleteByName(nombre);
    }

    @PostMapping("/cliente")
    Cliente crearProductoInv (Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/cliente")
    Cliente updateProductoInv (Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }
}