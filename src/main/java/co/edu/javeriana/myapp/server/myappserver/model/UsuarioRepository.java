package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    Optional<Usuario> findByUsuario(String username);

    void deleteByUsuario (String username);

}
