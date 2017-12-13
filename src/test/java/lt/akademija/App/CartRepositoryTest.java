package lt.akademija.App;

import lt.akademija.App.Model.Cart;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaCartRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CartRepositoryTest {

    @Autowired
    private JpaCartRepository jpaCartRepository;

    @Autowired
    private JpaProductRepository jpaProductRepository;



    @Test
    public void cartTest(){
        Product product = new Product();
        product.setName("Gerymas");
        Product product2 = new Product();
        product2.setName("Maistas");
        Product product3 = new Product();
        product3.setName("Ledai");

        Cart cart = new Cart("Petras");

        cart.getProducts().add(jpaProductRepository.save(product));
        cart.getProducts().add(jpaProductRepository.save(product2));
        cart.getProducts().add(jpaProductRepository.save(product3));
        jpaCartRepository.save(cart);

        Cart dbCart = jpaCartRepository.findOne(cart.getId());
        assertNotNull(cart);
        assertEquals(3, dbCart.getProducts().size());
        assertEquals("Petras", dbCart.getCustomerName());









    }
}

