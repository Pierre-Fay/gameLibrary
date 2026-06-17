package fr.eni.gamelibrary.dal;

import fr.eni.gamelibrary.bo.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
