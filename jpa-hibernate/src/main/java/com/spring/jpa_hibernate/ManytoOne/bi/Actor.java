package com.spring.jpa_hibernate.ManytoOne.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Actor {
    @Id
    @GeneratedValue

    private Integer actorId;
    private String actorName;
    private String actorPwd;

    @ManyToOne
    private ActorRole actorRole;
}
