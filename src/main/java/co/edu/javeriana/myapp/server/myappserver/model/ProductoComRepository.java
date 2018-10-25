package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductoComRepository extends CrudRepository<ProductoCom, Long>{
    
    Optional<ProductoCom> findByCodigoSKU(String codigoSKU);

    void deleteByCodigoSKU (String codigoSKU);

}
