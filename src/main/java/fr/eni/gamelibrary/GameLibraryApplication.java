package fr.eni.gamelibrary;

import fr.eni.gamelibrary.bo.Address;
import fr.eni.gamelibrary.bo.Customer;
import fr.eni.gamelibrary.dal.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GameLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameLibraryApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return (args) -> {

            Address address1 = new Address("23 Rue des roses", "37700", "San Miguel");
            Customer customer1 = new Customer("Marcel", "Pagnol", "marcel@pagnol.com", "0645830483", address1);

            customerRepository.save(customer1);
        };
    }

}
