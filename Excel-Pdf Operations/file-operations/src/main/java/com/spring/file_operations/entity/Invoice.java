package com.spring.file_operations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double amount;
    private String number;
    private String receivedDate;
}
