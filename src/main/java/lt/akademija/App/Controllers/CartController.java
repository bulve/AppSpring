package lt.akademija.App.Controllers;


import lt.akademija.App.Model.Cart;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaCartRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import lt.akademija.App.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class CartController {

    @Autowired
    private JpaCartRepository jpaCartRepository;

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "carts", method = RequestMethod.GET)
    public List<Cart> getAll(){
        return cartService.getAll();
    }
    @RequestMapping(value = "cart/{cart_id}/products", method = RequestMethod.GET)
    public List<Product> getProductsInCart(@PathVariable long cart_id){
        return cartService.getProducts(cart_id);
    }


    @RequestMapping(value = "cart", method = RequestMethod.POST)
    public Cart addCart(@RequestBody final Cart cart){
        return cartService.addCart(cart);
    }

    @RequestMapping(value = "cart/{id}", method = RequestMethod.GET)
    public Cart getCart(@PathVariable final long id){
        return cartService.findOne(id);
    }

    @RequestMapping(value = "cart/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable final long id){
        Cart cart = cartService.findOne(id);
        cartService.delete(cart);
    }

    @RequestMapping(value = "cart/add/{product_id}/to/{cart_id}", method = RequestMethod.POST)
    public List addProduct(@PathVariable Long product_id, @PathVariable Long cart_id){
//        cartService.addProduct(product_id, cart_id);
        Product product = jpaProductRepository.findOne(product_id);
        Cart cart = jpaCartRepository.findOne(cart_id);
        cart.getProducts().add(jpaProductRepository.findOne(product_id));
//        jpaCartRepository.save(cart);
//        Cart dbCart = jpaCartRepository.findOne(cart_id);

        return cart.getProducts();
    }





}
