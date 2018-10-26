package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    
    @Transactional
    @Query(value = "SELECT * FROM Usuario u WHERE u.usuario = :user", nativeQuery = true)
    Optional<Usuario> findByUsuario(@Param("user") String username);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Usuario u WHERE u.usuario = :user", nativeQuery = true)
    void deleteByUsuario (@Param("user") String username);

}
