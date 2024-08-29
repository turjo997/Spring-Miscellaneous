package com.spring.file_operations2.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Invoice {

    @Id
    @SequenceGenerator(
            name = "invoice_id_seq",
            sequenceName = "invoice_id_seq",
            allocationSize = 1, initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_id_seq")
    private Long id;
    private String name;
    private Double amount;
    private String location;


    public Invoice() {
    }

    public Invoice(Long id, String name, Double amount, String location) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
