package com.cars.mycarsbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDTO {
    private Long id;
    private Long marcaId;
    private String nome;
    private BigDecimal valorFipe;
    @JsonProperty("nome_marca")
    private String nomeMarca;
}
