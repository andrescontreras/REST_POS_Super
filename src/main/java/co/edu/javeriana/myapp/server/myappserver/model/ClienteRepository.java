package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    
    Optional<Cliente> findByIdentificacion(int identificacion);

    void deleteByIdentificacion (int identificacion);

}
