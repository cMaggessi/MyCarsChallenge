package com.cars.mycarsbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nome;
    @Column(precision = 10, scale = 3)
    private BigDecimal valorFipe;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;


}
