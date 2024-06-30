package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.CarDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Car;
import com.cars.mycarsbackend.model.Modelo;
import com.cars.mycarsbackend.repository.CarRepository;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.repository.ModeloRepository;
import com.cars.mycarsbackend.service.CarService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public List<CarDTO> findAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(CarDTO::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Carro não encontrado com ID: " + id));
    }

    @Override
    @Transactional
    public CarDTO createCar(CarDTO dto) {
        Car car = new Car();
        populateCarFromDTO(car, dto);
        Modelo modelo = getModeloById(dto.getModeloId());
        car.setModelo(modelo);
        car.setNomeModelo(modelo.getNome());
        carRepository.save(car);
        return CarDTO.mapper(car);
    }

    @Override
    @Transactional
    public CarDTO updateCar(CarDTO dto) {
        Car car = getById(dto.getId());
        populateCarFromDTO(car, dto);
        Modelo modelo = getModeloById(dto.getModeloId());
        car.setModelo(modelo);
        car.setNomeModelo(modelo.getNome());
        carRepository.save(car);
        return CarDTO.mapper(car);
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        Car car = getById(id);
        carRepository.delete(car);
    }


    private void populateCarFromDTO(Car car, CarDTO dto) {
        car.setAno(dto.getAno());
        car.setCombustivel(dto.getCombustivel());
        car.setNumPortas(dto.getNumPortas());
        car.setCor(dto.getCor());
        car.setValor(dto.getValor());
        car.setTimestampCadastro(dto.getTimestampCadastro()); // Convert Unix timestamp to Timestamp
    }


    private Modelo getModeloById(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Modelo não encontrado com ID: " + id));
    }
}
