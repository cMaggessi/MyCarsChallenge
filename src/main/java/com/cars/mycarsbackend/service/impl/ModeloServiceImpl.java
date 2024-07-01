package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.model.Modelo;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.repository.ModeloRepository;
import com.cars.mycarsbackend.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModeloServiceImpl implements ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<ModeloDTO> findAll() {
        List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream()
                .map(ModeloDTO::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public ModeloDTO getModelo(Long id) {
        Modelo modelo = getModeloEntity(id);
        return ModeloDTO.mapper(modelo);
    }

    @Override
    public ModeloDTO createModelo(ModeloDTO dto) {
        Marca marca = findMarcaById(dto.getMarcaId());
        Modelo newModelo = new Modelo();
        newModelo.setMarca(marca);
        newModelo.setValorFipe(dto.getValorFipe());
        newModelo.setNome(dto.getNome().toUpperCase());
        modeloRepository.save(newModelo);
        return ModeloDTO.mapper(newModelo);
    }

    @Override
    public ModeloDTO updateModelo(Long id, ModeloDTO dto) {
       Modelo modelo = getModeloEntity(id);
       modelo.setNome(dto.getNome().toUpperCase());
       modelo.setValorFipe(dto.getValorFipe());
       modeloRepository.save(modelo);
        return ModeloDTO.mapper(modelo);
    }

    @Override
    public ModeloDTO deleteModelo(Long id) {
        Modelo modelo = getModeloEntity(id);
        modeloRepository.delete(modelo);
        return ModeloDTO.mapper(modelo);
    }

    @Override
    public List<ModeloDTO> getModelosByMarca(Long marcaId) {
        Marca marca = findMarcaById(marcaId);
        List<Modelo> modelos = modeloRepository.findByMarca(marca);
        return modelos.stream()
                .map(ModeloDTO::mapper)
                .collect(Collectors.toList());

    }

    private Modelo getModeloEntity(Long id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Modelo com id: " + id + " não encontrado."));
    }

    public Marca findMarcaById(Long id) {
        return marcaRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Marca com id: "+id+" não encontrada."));
    }
}
