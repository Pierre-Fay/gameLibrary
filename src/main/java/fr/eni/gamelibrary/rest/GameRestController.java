package fr.eni.gamelibrary.rest;

import fr.eni.gamelibrary.bll.GameService;
import fr.eni.gamelibrary.bo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    // GET
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Game>> getGameById(@PathVariable(name = "id") Integer id) {
        return gameService.getGameById(id)
                .map(game -> ResponseEntity.ok(new ApiResponse<Game>(
                        true,
                        "Game found",
                        game)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<Game>(
                        false,
                        "Game not found",
                        null
                ))
                );
    }

}
