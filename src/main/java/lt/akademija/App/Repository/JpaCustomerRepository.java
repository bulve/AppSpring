package lt.akademija.App.Repository;

import lt.akademija.App.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, Long> {

}

