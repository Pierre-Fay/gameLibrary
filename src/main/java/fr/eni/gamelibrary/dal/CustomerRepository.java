package fr.eni.gamelibrary.dal;

import fr.eni.gamelibrary.bo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
