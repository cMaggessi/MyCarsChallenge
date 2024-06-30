package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.ModeloDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.model.Modelo;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.repository.ModeloRepository;
import com.cars.mycarsbackend.service.ModeloService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository, MarcaRepository marcaRepository) {
        this.modeloRepository = modeloRepository;
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }


    @Override
    public Modelo createModelo(ModeloDTO dto) {

        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new NotFoundException("Marca id: " + dto.getMarcaId() + " não encontrada."));
        Modelo newModel = new Modelo();
        newModel.setMarca(marca);
        newModel.setNome(dto.getNome().toUpperCase());
        newModel.setValorFipe(dto.getValorFipe());
        return modeloRepository.save(newModel);
    }


    @Override
    public Modelo getModelo(Long id) {
        Optional<Modelo> optModl = modeloRepository.findById(id);
        if(optModl.isEmpty()) {
            throw new NotFoundException("Modelo id: "+id+" não encontrado.");
        }
        return optModl.get();
    }


    @Override
    public Modelo updateModelo(ModeloDTO dto) {
        Modelo model = getModelo(dto.getId());
        model.setNome(dto.getNome().toUpperCase());
        model.setValorFipe(dto.getValorFipe());
        return modeloRepository.save(model);
    }

    @Override
    public Modelo deleteModelo(Long id) {
        Modelo modelDelete = getModelo(id);
        modeloRepository.delete(modelDelete);
        return modelDelete;

    }
}
