package fr.eni.gamelibrary.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,  length = 50)
    @NonNull
    private String name;

    @Column(nullable = false, unique = true, length = 13)
    @NonNull
    private String reference;

    private Integer minimumAge;

    private String description;

    private Integer averageDuration;

    @Column(nullable = false)
    @NonNull
    private Float dailyRate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "GAMES_GENRES", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    public void addGenre(Genre genre){
        genres.add(genre);
    }

}
