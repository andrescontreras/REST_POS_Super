package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductoInvRepository extends CrudRepository<ProductoInv, Long>{
    
    Optional<ProductoInv> findByCodigoSKU(String codigoSKU);

    void deleteByCodigoSKU (String codigoSKU);

}
