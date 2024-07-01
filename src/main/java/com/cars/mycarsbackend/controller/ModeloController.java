package com.cars.mycarsbackend.controller;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.dto.ResponseDTO;
import com.cars.mycarsbackend.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars/modelo")
public class ModeloController {

    @Autowired
    ModeloService modeloService;

    @PostMapping
    public ResponseEntity<ModeloDTO> createModelo(@RequestBody ModeloDTO dto) {
        ModeloDTO novoModelo = modeloService.createModelo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo);
    }

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> getModelos() {
        List<ModeloDTO> modelos = modeloService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> getModelo(@PathVariable Long id) {
        ModeloDTO modelo = modeloService.getModelo(id);
        return ResponseEntity.ok().body(modelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModelo(@PathVariable Long id, @RequestBody ModeloDTO dto) {
        dto.setId(id);
        ModeloDTO modeloAtualizado = modeloService.updateModelo(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteModelo(@PathVariable Long id) {
        ModeloDTO deletedModelo = modeloService.deleteModelo(id);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .message("Modelo " + id + " deletado com sucesso!")
                .statusCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}
