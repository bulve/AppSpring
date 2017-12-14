package lt.akademija.App.Controllers;



import lt.akademija.App.Model.Product;

import lt.akademija.App.Repository.JpaBrandRepository;
import lt.akademija.App.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {


    @Autowired
    private ProductService productService;






    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productService.getProducts();

    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable long id){
        return productService.getProductById(id);

    }

    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@Valid @RequestBody final Product product){
       return productService.createProduct(product);

//        productService.createProduct(new Product( "Nokia", "Description", 222.55, 20));
//        productService.createProduct(new Product( "Motorola", "Description", 9.55, 20));
//        productService.createProduct(new Product( "Samsung", "Description", 22772.55, 20));
//        productService.createProduct(new Product( "Apple", "Description", 88.55, 20));
//        productService.createProduct(new Product( "Nokia", "Description", 111, 10));

    }



    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Product removeProductById(@PathVariable final Long id){
        return productService.remove(productService.getProductById(id));
    }


    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
    public Product updateProductById(@PathVariable long id, @RequestBody final Product product){
        Product oldOne = productService.getProductById(id);
        if(oldOne == null){
            throw new NullPointerException();
        }
        return productService.update(oldOne, product);
    }

    @RequestMapping(value = "/api/product/{product_id}/brand/{brand_id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addBrandToProduct(@PathVariable long product_id, @PathVariable long brand_id){
        productService.addProductBrand(product_id, brand_id);
    }






}
