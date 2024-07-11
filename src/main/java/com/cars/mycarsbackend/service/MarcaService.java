package com.cars.mycarsbackend.service;

import com.cars.mycarsbackend.dto.MarcaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarcaService {
    List<MarcaDTO> findAll();
    MarcaDTO getById(Long id);
    MarcaDTO updateMarca(MarcaDTO marcaDTO);
    MarcaDTO createMarca(MarcaDTO marcaDTO);
    void deleteMarca(Long id);

}
