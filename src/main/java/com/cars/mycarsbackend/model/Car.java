package com.cars.mycarsbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp_cadastro")
    private Timestamp timestampCadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @Column(name = "nome_modelo")
    private String nomeModelo;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private String combustivel;

    @Column(name = "num_portas", nullable = false)
    private int numPortas;

    @Column(nullable = false)
    private String cor;

    @Column(name = "valor", precision = 8, scale = 3)
    private BigDecimal valor;



}
