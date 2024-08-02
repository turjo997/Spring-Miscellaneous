package com.spring.jpa_hibernate.OnetoOne.uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Farmer {

    @Id
    @GeneratedValue

    private Integer farmerId;
    private String farmerName;
    private String farmerPwd;

    @OneToOne
    private FarmerRole farmerRole;
}
