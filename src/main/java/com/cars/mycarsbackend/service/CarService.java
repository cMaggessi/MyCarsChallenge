package com.cars.mycarsbackend.service;

import com.cars.mycarsbackend.dto.CarDTO;
import com.cars.mycarsbackend.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<CarDTO> findAll();
    Car getById(Long id);
    CarDTO createCar(CarDTO dto);

    CarDTO updateCar(CarDTO dto);

    void deleteCar(Long id);

}
