package com.spring.model_mapper.dto;

import com.spring.model_mapper.model.GameMode;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class GameDTO {
    private Long id;
    private String name;
    private Long creationTime;
    private String creator;
    private int totalPlayers;

    private GameMode mode;
    private int maxPlayers;
}
