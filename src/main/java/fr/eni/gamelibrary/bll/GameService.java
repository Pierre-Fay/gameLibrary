package fr.eni.gamelibrary.bll;

import fr.eni.gamelibrary.bo.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {

    List<Game> getAllGames();

    Optional<Game> getGameById(Integer id);
}
