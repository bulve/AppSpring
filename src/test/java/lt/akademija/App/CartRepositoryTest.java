package lt.akademija.App;

import lt.akademija.App.Model.Cart;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaCartRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.method.P;
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
        jpaProductRepository.save(product);
        Product p = jpaProductRepository.findOne(product.getId());
        Product p2 = jpaProductRepository.findOne(product2.getId());
        Product p3 = jpaProductRepository.findOne(product3.getId());

        cart.getProducts().add(p);
        cart.getProducts().add(p2);
        cart.getProducts().add(p3);
        jpaCartRepository.save(cart);


        
        Cart dbCart = jpaCartRepository.findOne(cart.getId());
        assertNotNull(cart);
        assertEquals(3, dbCart.getProducts().size());
        assertEquals("Petras", dbCart.getCustomerName());









    }
}

