package com.cars.mycarsbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="nome_marca")
    private String nomeMarca;
}
