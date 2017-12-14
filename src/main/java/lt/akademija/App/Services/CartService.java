package lt.akademija.App.Services;


import lt.akademija.App.Model.Cart;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaCartRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private JpaCartRepository jpaCartRepository;
    @Autowired
    private JpaProductRepository jpaProductRepository;

    public Cart addCart(Cart cart) {
        if (cart == null){
            throw new NullPointerException();
        }
        return jpaCartRepository.save(cart);
    }

    public Cart findOne(Long id)  {
        if(id < 0){
            throw new RuntimeException();
        }
        return jpaCartRepository.findOne(id);
    }

    public List<Cart> getAll(){
        return jpaCartRepository.findAll();
    }


    public List<Product> getProducts(long cart_id){
        Cart cart = jpaCartRepository.findOne(cart_id);
        return cart.getProducts();
    }

    public void delete(Cart cart){
        jpaCartRepository.delete(cart);
    }


    public void addProduct(long product_id, long cart_id){

       Cart cart = jpaCartRepository.findOne(cart_id);

       if(cart == null){
            throw new NullPointerException();
        }
        cart.getProducts().add(jpaProductRepository.findOne(product_id));

    }

    public void addToCart(Long cart_id, Long product_id){
        Cart cart = jpaCartRepository.findOne(cart_id);
        Product product = jpaProductRepository.findOne(product_id);
        if(cart == null || product == null){
            throw new NullPointerException();
        }
        cart.getProducts().add(product);

    }
}
