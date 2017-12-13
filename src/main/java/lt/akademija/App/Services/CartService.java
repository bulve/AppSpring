package lt.akademija.App.Services;


import lt.akademija.App.Model.Cart;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaCartRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public Cart addProduct(long cart_id, long product_id){
        Cart cart = jpaCartRepository.findOne(cart_id);
        Product product = jpaProductRepository.findOne(product_id);
        List<Product>products = cart.getProducts();
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);

        //product.setCart(cart);
        //jpaProductRepository.save(product);

        cart.setProducts(products);
        //jpaProductRepository.saveAndFlush(product);

        return jpaCartRepository.saveAndFlush(cart);

    }
}
