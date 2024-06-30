package com.cars.mycarsbackend.dto;

import com.cars.mycarsbackend.model.Car;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private Long id;

    @JsonProperty("timestamp_cadastro")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp timestampCadastro;

    @JsonProperty("modelo_id")
    private Long modeloId;

    private Integer ano;
    private String combustivel;

    @JsonProperty("num_portas")
    private Integer numPortas;

    private String cor;

    @JsonProperty("nome_modelo")
    private String nomeModelo;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "###,###.###")
    private BigDecimal valor;

    public static CarDTO mapper(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .timestampCadastro(car.getTimestampCadastro())
                .modeloId(car.getModelo().getId())
                .nomeModelo(car.getModelo().getNome())
                .combustivel(car.getCombustivel())
                .numPortas(car.getNumPortas())
                .ano(car.getAno())
                .cor(car.getCor())
                .valor(car.getValor())
                .build();
    }
}
