package com.spring.jpa_hibernate.OnetoMany.UniDir;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Integer playerId;
    private String playerName;
    private String playerPwd;

    @OneToMany
    private List<PlayerRole> playerRoles;
}
