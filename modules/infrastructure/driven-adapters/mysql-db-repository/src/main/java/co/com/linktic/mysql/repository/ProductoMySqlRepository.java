package co.com.linktic.mysql.repository;

import co.com.linktic.mysql.entities.ProductoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoMySqlRepository extends CrudRepository<ProductoEntity,Integer> {
}
