package com.spring.jpa_hibernate.OnetoOne.bi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Singer {

    @Id
    @GeneratedValue

    private Integer singerId;
    private String singerName;
    private String singerPwd;


    @OneToOne
    private SingerRole singerRole;
}
