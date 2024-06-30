package com.cars.mycarsbackend.service;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.model.Modelo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModeloService {
    List<Modelo> findAll();
    Modelo getModelo(Long id);

    Modelo createModelo(ModeloDTO dto);
    Modelo updateModelo(ModeloDTO dto);
    Modelo deleteModelo(Long id);
}
