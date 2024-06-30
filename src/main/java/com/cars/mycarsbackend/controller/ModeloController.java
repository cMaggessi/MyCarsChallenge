package com.cars.mycarsbackend.controller;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.dto.ResponseDTO;
import com.cars.mycarsbackend.model.Modelo;
import com.cars.mycarsbackend.service.ModeloService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/cars/modelo")
public class ModeloController {


    @Autowired
    ModeloService modeloService;

    @PostMapping
    public ResponseEntity<Modelo> createModelo(@RequestBody ModeloDTO dto) {
        Modelo novoModelo = modeloService.createModelo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo);
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> getModelos() {
        List<Modelo> modelos = modeloService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(modelos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable Long id, @RequestBody ModeloDTO dto) {
        dto.setId(id);
        Modelo modeloAtualizado = modeloService.updateModelo(dto);
        return ResponseEntity.status(HttpStatus.OK).body(modeloAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> deleteModelo(@PathVariable Long id) {
        Modelo deletedModelo = modeloService.deleteModelo(id);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .message("Modelo " + deletedModelo.getId() + " deletado com sucesso!")
                .statusCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}
