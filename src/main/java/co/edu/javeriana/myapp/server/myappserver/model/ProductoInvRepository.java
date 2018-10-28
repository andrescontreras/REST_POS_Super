package co.edu.javeriana.myapp.server.myappserver.model;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductoInvRepository extends CrudRepository<ProductoInv, Long>{
    
    
    @Transactional
    ProductoInv findByCodigoSKU( String codigoSKU);

    @Transactional
    ProductoInv findByNombre(String nombre);

    @Modifying
    @Transactional
    void deleteByCodigoSKU (String codigoSKU);

    @Modifying
    @Transactional
    void deleteByNombre (String nombre);

    
    @Transactional
    @Query(value="SELECT p FROM productoInv p WHERE p.precio > :v1 and p.precio < :v2", nativeQuery=true)
    ProductoInv FilterByPrecio(@Param("v1") int v1,@Param("v2") int v2);
}
