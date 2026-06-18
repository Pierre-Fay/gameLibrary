package fr.eni.gamelibrary.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false,  length = 13, unique = true)
    @NonNull
    private String barcode;

    @Basic(optional = false)
    @NonNull
    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    @NonNull
    private Game game;
}
