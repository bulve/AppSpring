package lt.akademija.App.Services;


import lt.akademija.App.Model.Product;
import lt.akademija.App.Model.ProductBrand;
import lt.akademija.App.Repository.JpaBrandRepository;
import lt.akademija.App.Repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private JpaProductRepository jpaProductRepository;

    @Autowired
    private JpaBrandRepository jpaBrandRepository;

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
        Product product1 = product;
        jpaProductRepository.delete(product);
        return product1;
    }

    public Product update(Product oldOne, Product product){
        oldOne.setQuantity(product.getQuantity());
        oldOne.setPrice(product.getPrice());
        oldOne.setDescription(product.getDescription());
        oldOne.setName(product.getName());

        return jpaProductRepository.save(oldOne);
    }

    @Transactional
    public void addProductBrand(long product_id, long brand_id) {
//        ProductBrand productBrand = jpaBrandRepository.findOne(brand_id);
//        productBrand.getProducts().add(jpaProductRepository.findOne(product_id));
        ProductBrand brand = jpaBrandRepository.findOne(brand_id);
        Product product = jpaProductRepository.findOne(product_id);
        if(brand == null || product == null){
            throw new NullPointerException();
        }
        brand.addProduct(product);
        //Product product = jpaProductRepository.findOne(product_id);
        //jpaProductRepository.findOne(product_id).setProductBrand(jpaBrandRepository.findOne(brand_id));
    }
}
