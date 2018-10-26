package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoInvRepository extends CrudRepository<ProductoInv, Long>{
    
    @Query(value ="SELECT p FROM ProductoInv p WHERE p.codigoSKU = :codigo", nativeQuery = true)
    Optional<ProductoInv> findByCodigoSKU(@Param("codigo") String codigoSKU);
    
    @Modifying
    @Transactional
    @Query(value ="DELETE FROM ProductoInv p WHERE p.codigoSKU = :codigo", nativeQuery = true)
    void deleteByCodigoSKU (@Param("codigo") String codigoSKU);
}
