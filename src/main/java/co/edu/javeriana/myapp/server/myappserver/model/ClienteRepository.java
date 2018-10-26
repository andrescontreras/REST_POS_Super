package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
    @Transactional
    Cliente findByIdentificacion(int identificacion);
    
    @Transactional
    Cliente findByNombre(String nombre);

    
    @Modifying
    @Transactional
    @Query(value="DELETE FROM Cliente c WHERE c.identificacion = :identificacion", nativeQuery = true)
    void deleteByIdentificacion (@Param("identificacion") int identificacion);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Cliente WHERE Cliente.nombre = :nombre", nativeQuery = true)
    void deleteByName (@Param("nombre") String nombre);
    
}
