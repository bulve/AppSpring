package lt.akademija.App.Model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;

    //@OneToOne(mappedBy = "customer")


    public Customer(){

    }


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
