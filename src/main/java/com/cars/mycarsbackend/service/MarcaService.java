package com.cars.mycarsbackend.service;

import com.cars.mycarsbackend.dto.MarcaDTO;
import com.cars.mycarsbackend.model.Marca;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarcaService {
    List<Marca> findAll();
    Marca getById(Long id);
    Marca updateMarca(MarcaDTO marcaDTO);
    Marca createMarca(MarcaDTO marcaDTO);
    Marca deleteMarca(Long id);

}
