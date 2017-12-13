package lt.akademija.App.Model;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();
    Product getProductById(long id);
    void addProduct(NewProduct product);
    Product updateProductById(long id, NewProduct product);

}
