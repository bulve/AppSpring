package lt.akademija.App.Repository;

import lt.akademija.App.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaCartRepository extends JpaRepository<Cart, Long>{

//    @Transactional
//    List<Cart> findAll();
//
//    @Transactional
//    Cart save(Cart cart);
//
//    @Transactional
//    Cart findOne(long id);
//
//    @Transactional
//    void delete(Cart cart);
//
//    @Transactional
//    Cart saveAndFlush(Cart cart);


}
