package fr.eni.gamelibrary.dal;

import fr.eni.gamelibrary.bo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstNameStartingWith(String prefix);
}
