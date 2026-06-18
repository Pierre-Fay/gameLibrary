package fr.eni.gamelibrary.bll;

import fr.eni.gamelibrary.bo.Customer;
import fr.eni.gamelibrary.dal.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
