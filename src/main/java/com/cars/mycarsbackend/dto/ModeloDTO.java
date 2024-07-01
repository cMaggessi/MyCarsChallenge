package com.cars.mycarsbackend.dto;

import com.cars.mycarsbackend.model.Modelo;
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
    @JsonProperty("marca_id")
    private Long marcaId;
    private String nome;
    @JsonProperty("valor_fipe")
    private BigDecimal valorFipe;
    @JsonProperty("nome_marca")
    private String nomeMarca;

    public static ModeloDTO mapper(Modelo modelo) {
        return ModeloDTO.builder()
                .id(modelo.getId())
                .marcaId(modelo.getMarca().getId())
                .nome(modelo.getNome())
                .valorFipe(modelo.getValorFipe())
                .nomeMarca(modelo.getMarca().getNomeMarca())
                .build();
    }
}
