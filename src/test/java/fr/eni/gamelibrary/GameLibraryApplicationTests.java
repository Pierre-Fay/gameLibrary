package fr.eni.gamelibrary;

import fr.eni.gamelibrary.bo.Address;
import fr.eni.gamelibrary.bo.Customer;
import fr.eni.gamelibrary.dal.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GameLibraryApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testCustomerFirstNameIsMarcel() {

        // 0. Delete all to have a clean database for the test
        customerRepository.deleteAll();

        // 1. Arrange: Create the Address and Customer (just like your runner)
        Address address1 = new Address(null, "23 Rue des roses", "37700", "San Miguel");
        Customer customer1 = new Customer("Marcel", "Pagnol", "marcel@pagnol.com", "0645830483", address1);

        // 2. Act: Save the customer to the database
        Customer savedCustomer = customerRepository.save(customer1);

        // 3. Assert: Fetch it back and verify the first name is "Marcel"
        assertThat(savedCustomer).isNotNull();
    }

}
