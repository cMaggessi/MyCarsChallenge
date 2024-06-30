package com.cars.mycarsbackend.controller;

import com.cars.mycarsbackend.dto.CarDTO;
import com.cars.mycarsbackend.dto.ResponseDTO;
import com.cars.mycarsbackend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDTO>> getCars() {
        List<CarDTO> cars = carService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @PostMapping
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO dto) {
        CarDTO newCarDTO = carService.createCar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO dto) {
        dto.setId(id);
        CarDTO updatedCarDTO = carService.updateCar(dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCarDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseDTO> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .message("Carro com ID " + id + " deletado com sucesso!")
                .statusCode(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
