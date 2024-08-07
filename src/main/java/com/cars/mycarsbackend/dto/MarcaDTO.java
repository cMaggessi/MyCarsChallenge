package com.cars.mycarsbackend.dto;

import com.cars.mycarsbackend.model.Marca;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

    private Long id;

    @JsonProperty("nome_marca")
    private String nomeMarca;


    public static MarcaDTO mapper(Marca marca) {
        return MarcaDTO.builder()
                .id(marca.getId())
                .nomeMarca(marca.getNomeMarca())
                .build();
    }
}
