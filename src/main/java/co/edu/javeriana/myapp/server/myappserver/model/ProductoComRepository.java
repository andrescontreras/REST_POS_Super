package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoComRepository extends CrudRepository<ProductoCom, Long>{
    
    @Transactional
    ProductoCom findByCodigoSKU( String codigoSKU);

    @Transactional
    ProductoCom findByNombre( String nombre);
    @Transactional
    @Modifying
    @Query(value="DELETE FROM ProductoCom WHERE ProductoCom.codigoSKU = :codigo", nativeQuery = true)
    void deleteByCodigoSKU (@Param("codigo") String codigoSKU);

}

