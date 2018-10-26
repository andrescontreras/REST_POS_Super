package co.edu.javeriana.myapp.server.myappserver.model;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoInvRepository extends CrudRepository<ProductoInv, Long>{
    
    
    @Query(value ="SELECT * FROM ProductoInv p WHERE p.codigoSKU = :codigoSKU", nativeQuery = true)
    @Transactional
    ProductoInv findByCodigoSKU(@Param("codigoSKU") String codigoSKU);

    @Modifying
    @Transactional
    @Query(value ="DELETE FROM ProductoInv p WHERE p.codigoSKU = :codigoSKU", nativeQuery = true)
    void deleteByCodigoSKU (@Param("codigoSKU") String codigoSKU);
}
