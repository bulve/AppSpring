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
@RequestMapping(value = "/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private JpaCartRepository jpaCartRepository;

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cart> getAll(){
        return cartService.getAll();
    }
    @RequestMapping(value = "/{cart_id}/products", method = RequestMethod.GET)
    public List<Product> getProductsInCart(@PathVariable long cart_id){
        return cartService.getProducts(cart_id);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cart addCart(@RequestBody final Cart cart){
        return cartService.addCart(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart getCart(@PathVariable final long id){
        return cartService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable final long id){
        Cart cart = cartService.findOne(id);
        cartService.delete(cart);
    }

    @RequestMapping(value = "/add/{product_id}/to/{cart_id}", method = RequestMethod.POST)
    public void addProduct(@PathVariable Long product_id, @PathVariable Long cart_id){

        //cartService.addProduct(product_id, cart_id);
        cartService.addToCart(cart_id,product_id);
    }







}
