package co.edu.javeriana.myapp.server.myappserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.myapp.server.myappserver.model.Usuario;
import co.edu.javeriana.myapp.server.myappserver.model.UsuarioRepository;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/usuario")
    Iterable<Usuario> findAll()
    {
        return usuarioRepository.findAll();
    }

    @RequestMapping("/usuario/{id}")
    Optional<Usuario> findById(@PathVariable("id") Long id)
    {
        return usuarioRepository.findById(id);
    }

    @RequestMapping("/usuario/u/{username}")
    Usuario findByCodigoSKU(@PathVariable("username") String username)
    {
        return usuarioRepository.findByUsuario(username);
    }

    @DeleteMapping("/usuario/{id}")
    void deleteById(@PathVariable("id") Long id)
    {
        usuarioRepository.deleteById(id);
    }

    @DeleteMapping("/usuario/u/{usuario}")
    void deleteBySKU(@PathVariable("usuario") String usuario)
    {
        usuarioRepository.deleteByUsuario(usuario);
    }

    @PostMapping("/usuario")
    Usuario crearUsuario (@RequestBody Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario")
    Usuario updateUsuario ( @RequestBody Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }
}