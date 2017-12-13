package lt.akademija.App.Services;


import lt.akademija.App.Model.Product;
import lt.akademija.App.Repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private JpaProductRepository jpaProductRepository;

    public Product createProduct(Product product){
        return jpaProductRepository.save(product);
    }

    public List<Product> getProducts(){
        return jpaProductRepository.findAll();
    }

    public Product getProductById(long id){
        return jpaProductRepository.findOne(id);
    }

    public Product remove(Product product){
        Product p = product;
        jpaProductRepository.delete(product);
        return p;
    }

    public Product update(Product oldOne, Product product){
        oldOne.setQuantity(product.getQuantity());
        oldOne.setPrice(product.getPrice());
        oldOne.setDescription(product.getDescription());
        oldOne.setName(product.getName());

        return jpaProductRepository.save(oldOne);
    }


}
