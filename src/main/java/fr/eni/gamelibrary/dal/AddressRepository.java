package fr.eni.gamelibrary.dal;

import fr.eni.gamelibrary.bo.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
