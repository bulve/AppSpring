package lt.akademija.App.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private String image;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    public Product() {
    }

    public Product( String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.image = "/samsung.jpg";
        this.price = price;
        this.quantity = quantity;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public Cart getCart(){
        return cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
