package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.MarcaDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public List<Marca> findAll() {

        return marcaRepository.findAll();
    }

    @Override
    public Marca getById(Long id) {
        Optional<Marca> optMarca = marcaRepository.findById(id);
        if (optMarca.isEmpty()) {
            throw new NotFoundException("Marca id: "+id+" não encontrada.");
        }
        return optMarca.get();
    }

    @Override
    public Marca updateMarca(MarcaDTO marcaDTO) {
        Marca marca = getById(marcaDTO.getId());
        marca.setNomeMarca(marcaDTO.getNomeMarca());
        return marcaRepository.save(marca);
    }

    @Override
    public Marca createMarca(MarcaDTO marcaDTO) {
        Marca newMarca = new Marca();
        newMarca.setNomeMarca(marcaDTO.getNomeMarca());
        return marcaRepository.save(newMarca);

    }

    @Override
    public Marca deleteMarca(Long id) {
        Marca marcaDel = getById(id);
        marcaRepository.delete(marcaDel);
        return marcaDel;
    }

}
