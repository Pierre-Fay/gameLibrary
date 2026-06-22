package fr.eni.gamelibrary.bll;

import fr.eni.gamelibrary.bo.Game;
import fr.eni.gamelibrary.dal.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository gameRepo;

    @Override
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    @Override
    public Optional<Game> getGameById(Integer id) {
        return gameRepo.findById(id);
    }
}
