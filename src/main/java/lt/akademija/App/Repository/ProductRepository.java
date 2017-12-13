package lt.akademija.App.Repository;


import lt.akademija.App.Model.NewProduct;
import lt.akademija.App.Model.Product;
import lt.akademija.App.Model.ProductDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository implements ProductDAO {

    private List<Product> products = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public ProductRepository(){

//        products.add(new Product(idGenerator.incrementAndGet(), "Nokia", "Description", 222.55, 20));
//        products.add(new Product(idGenerator.incrementAndGet(), "Motorola", "Description", 9.55, 20));
//        products.add(new Product(idGenerator.incrementAndGet(), "Samsung", "Description", 22772.55, 20));
//        products.add(new Product(idGenerator.incrementAndGet(), "Apple", "Description", 88.55, 20));
//        products.add(new Product(idGenerator.incrementAndGet(), "Nokia", "Description", 111, 10));

    }

    public void addProduct(NewProduct product){
        //products.add(new Product(idGenerator.incrementAndGet(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()));
        products.add(new Product( product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()));
    }

    public List<Product> getProducts(){
        return products;
    }

    @Override
    public Product getProductById(long id) {
        return getProducts().stream().filter(product -> product.getId() == id).findFirst().orElseThrow(()->new RuntimeException());

    }

    @Override
    public Product updateProductById(long id, NewProduct product) {
        Product oldProduct = getProductById(id);
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantity(product.getQuantity());
        return oldProduct;
    }


}
