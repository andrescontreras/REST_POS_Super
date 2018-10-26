package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    
    @Transactional
    Optional<Usuario> findByUsuario(String usuario);

    @Transactional
    @Modifying
    void deleteByUsuario (String usuario);

}
