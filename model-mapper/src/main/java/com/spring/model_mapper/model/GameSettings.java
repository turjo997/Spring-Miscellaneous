package com.spring.model_mapper.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameSettings {

    private GameMode gameMode;
    private int maxPlayers;
}
