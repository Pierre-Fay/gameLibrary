package fr.eni.gamelibrary;

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
            Customer customer1 = new Customer("Marcel", "Pagnol", "marcel@pagnol.com", "0645830483");

            customerRepository.save(customer1);
        };
    }

}
