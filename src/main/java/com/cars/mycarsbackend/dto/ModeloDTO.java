package com.cars.mycarsbackend.dto;

import com.cars.mycarsbackend.model.Marca;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String nomeMarca;
}
