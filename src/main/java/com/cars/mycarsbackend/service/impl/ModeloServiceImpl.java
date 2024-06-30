package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.model.Modelo;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.repository.ModeloRepository;
import com.cars.mycarsbackend.service.ModeloService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<ModeloDTO> findAll() {
        List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModeloDTO createModelo(ModeloDTO dto) {
        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new NotFoundException("Marca id: " + dto.getMarcaId() + " não encontrada."));

        Modelo newModel = new Modelo();
        BeanUtils.copyProperties(dto, newModel); // Copy properties from DTO to entity
        newModel.setMarca(marca);
        newModel.setNome(dto.getNome().toUpperCase());

        Modelo savedModel = modeloRepository.save(newModel);
        return convertToDTO(savedModel);
    }

    @Override
    public ModeloDTO getModelo(Long id) {
        Modelo modelo = getModeloEntity(id);
        return convertToDTO(modelo);
    }

    @Override
    public ModeloDTO updateModelo(ModeloDTO dto) {
        Modelo model = getModeloEntity(dto.getId());
        BeanUtils.copyProperties(dto, model); // Copy properties from DTO to entity
        model.setNome(dto.getNome().toUpperCase());
        Modelo updatedModel = modeloRepository.save(model);
        return convertToDTO(updatedModel);
    }

    @Override
    public ModeloDTO deleteModelo(Long id) {
        Modelo modelo = getModeloEntity(id);
        modeloRepository.delete(modelo);
        return convertToDTO(modelo);
    }

    // Helper method to get Modelo entity by ID
    private Modelo getModeloEntity(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Modelo id: " + id + " não encontrado."));
    }

    // Convert Modelo entity to ModeloDTO
    private ModeloDTO convertToDTO(Modelo modelo) {
        ModeloDTO dto = new ModeloDTO();
        BeanUtils.copyProperties(modelo, dto);
        dto.setMarcaId(modelo.getMarca().getId());
        return dto;
    }
}
