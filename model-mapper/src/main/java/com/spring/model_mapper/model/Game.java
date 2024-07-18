package com.spring.model_mapper.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Game {
    private Long id;
    private String name;
    private Long timeStamp;

    private Player creator;
    private List<Player> players = new ArrayList<>();

    private GameSettings gameSettings;

    public Game(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addPlayer(Player player){
        if (players == null){
            players = new ArrayList<>();
        }

        players.add(player);
    }
}
