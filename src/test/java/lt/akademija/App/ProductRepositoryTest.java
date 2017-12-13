package lt.akademija.App;

import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Test
    public void productTest(){
        Product product10 = new Product();
        product10.setName("Jomantas");
        Product product = new Product();
        product.setName("Gerymas");
        Product product2 = new Product();
        product2.setName("Maistas");
        Product product3 = new Product();
        product3.setName("Ledai");
        assertNotNull(product);
        assertNotNull(product2);
        assertNotNull(product3);
        assertNotNull(product10);

        jpaProductRepository.save(product10);
        assertEquals(1,jpaProductRepository.count());
        jpaProductRepository.save(product);
        jpaProductRepository.save(product2);
        jpaProductRepository.save(product3);
        assertEquals(4, jpaProductRepository.count());

//        jpaProductRepository.save(product10);
//        Long value = (long)1;
//        assertNotNull(product10);
//
//        assertNotNull(jpaProductRepository.findOne(product10.getId()));
//
//        Product dbProduct = jpaProductRepository.findOne(value);
//
//        assertEquals(product10.getName(), dbProduct.getName());
    }
}
