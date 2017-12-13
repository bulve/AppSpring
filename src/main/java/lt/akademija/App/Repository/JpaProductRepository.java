package lt.akademija.App.Repository;


import lt.akademija.App.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<Product, Long>{

//    @Transactional
//    List<Product> findAll();
//
//    @Transactional
//    Product save(Product product);
//
//    //Product saveWhereId(Long id, Product product);
//    @Transactional
//    Product findOne(Long id);
//
//    @Transactional
//    void delete(Product product);
//
//    @Transactional
//    Product saveAndFlush(Product product);



}
