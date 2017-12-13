package lt.akademija.App.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String customerName;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product>();

    public Cart(){

    }

    public Cart(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product){
        if(products.contains(product)){
            products.remove(product);
        }
    }
}
