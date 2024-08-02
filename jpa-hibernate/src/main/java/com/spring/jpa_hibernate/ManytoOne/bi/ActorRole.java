package com.spring.jpa_hibernate.ManytoOne.bi;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ActorRole {
    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;

    @OneToMany(mappedBy = "actorRole", cascade = CascadeType.ALL)
    private List<Actor> actors;
}
