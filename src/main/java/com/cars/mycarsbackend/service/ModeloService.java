package com.cars.mycarsbackend.service;

import com.cars.mycarsbackend.dto.ModeloDTO;

import java.util.List;

public interface ModeloService {
    List<ModeloDTO> findAll();
    ModeloDTO getModelo(Long id);

    ModeloDTO createModelo(ModeloDTO dto);
    ModeloDTO updateModelo(ModeloDTO dto);
    ModeloDTO deleteModelo(Long id);
}
