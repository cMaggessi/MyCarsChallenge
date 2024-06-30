package com.cars.mycarsbackend.controller;

import com.cars.mycarsbackend.dto.MarcaDTO;
import com.cars.mycarsbackend.dto.ResponseDTO;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars/marca")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> listMarcas() {
        List<Marca> marcas = marcaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(marcas);
    }

    @PostMapping
    public ResponseEntity<Marca> createMarca( @RequestBody MarcaDTO dto) {
        Marca novaMarc = marcaService.createMarca(dto);
        return ResponseEntity.status(HttpStatus.OK).body(novaMarc);
    }

    @PutMapping("{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Long id, @RequestBody MarcaDTO dto) {
        dto.setId(id);
        Marca updtMarca = marcaService.updateMarca(dto);
        return ResponseEntity.status(HttpStatus.OK).body(updtMarca);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> deleteMarca(@PathVariable Long id) {
        Marca marcaDeletada = marcaService.deleteMarca(id);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .message("Marca " + marcaDeletada.getId() + " deletada com sucesso!")
                .statusCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }


}
