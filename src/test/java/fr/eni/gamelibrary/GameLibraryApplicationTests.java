package fr.eni.gamelibrary;

import fr.eni.gamelibrary.bll.CustomerService;
import fr.eni.gamelibrary.bo.Address;
import fr.eni.gamelibrary.bo.Customer;
import fr.eni.gamelibrary.bo.Genre;
import fr.eni.gamelibrary.dal.CustomerRepository;
import fr.eni.gamelibrary.dal.GenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class GameLibraryApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void testCustomerIsNotNull() {

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

    @Test
    void testGenreExists() {

        genreRepository.deleteAll();

        Genre genre1 = new Genre("Horror");

        Genre savedGenre = genreRepository.save(genre1);

        assertThat(savedGenre).isNotNull();

    }

    @Test
    void testFindCustomersByName() {
        customerRepository.deleteAll();

        Address address2 = new Address("24 Rue des roses", "37700", "San Miguel");
        Customer customer2 = new Customer("Marcel", "L'epagnole", "marcel@pagnol.com", "0645830483", address2);

        Address address3 = new Address("10 Rue des Lilas", "13700", "Ville du Sud");
        Customer customer3 = new Customer("Martincito", "Pants", "martinbizz@shady.com", "0645830453", address3);

        Address address4 = new Address("139 Rue Incognito", "59000", "Lille");
        Customer customer4 = new Customer("Antoine", "Lechti", "clenord@froid.com", "0645830481", address4);

        Customer savedCustomer2 = customerRepository.save(customer2);
        Customer savedCustomer3 = customerRepository.save(customer3);
        Customer savedCustomer4 = customerRepository.save(customer4);

        List<Customer> query = customerRepository.findByFirstNameStartingWith("Mar");

        assertThat(query).hasSize(2).containsExactlyInAnyOrder(savedCustomer2, savedCustomer3);
    }

    @Test
    void testCustomerUpdateValid() {

        // Arrange
        customerRepository.deleteAll();

        Address address = new Address("24 Rue des roses", "37700", "San Miguel");
        Customer customer = new Customer("Marcel", "L'epagnole", "marcel@pagnol.com", "0645830483", address);

        Address addressBis = new Address("10 Rue des Lilas", "13700", "Ville du Sud");
        Customer customerBis = new Customer("Martincito", "Pants", "martinbizz@shady.com", "0645830453", addressBis);

        Customer savedCustomer = customerRepository.save(customer);

        // Act
        customerBis.setId(savedCustomer.getId());
        customerBis.getAddress().setId(savedCustomer.getAddress().getId());
        customerService.updateCustomer(customerBis);

        Customer updatedCustomer = customerRepository.findById(savedCustomer.getId()).get();

        // Assert
        assertThat(updatedCustomer.getFirstName()).isEqualTo("Martincito");

    }

    @Test
    void testCustomerUpdateCaseCustomerNotFound() {

        // Arrange
        customerRepository.deleteAll();

        // Act and Assert
        customerService.updateCustomer(null);

    }
}
