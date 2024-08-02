package com.spring.jpa_hibernate.ManytoOne.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Actress {

    @Id
    @GeneratedValue
    private Integer actressId;
    private String actressName;
    private String actressPwd;

    @ManyToOne
    private ActressRole actressRole;
}
