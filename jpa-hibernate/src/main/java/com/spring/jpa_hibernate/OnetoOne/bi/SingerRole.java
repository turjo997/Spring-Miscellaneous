package com.spring.jpa_hibernate.OnetoOne.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class SingerRole {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;

    @OneToOne(mappedBy = "singerRole")
    private Singer singer;
}
