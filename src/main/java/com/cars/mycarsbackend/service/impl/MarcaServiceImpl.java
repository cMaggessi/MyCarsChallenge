package com.cars.mycarsbackend.service.impl;

import com.cars.mycarsbackend.dto.MarcaDTO;
import com.cars.mycarsbackend.exception.NotFoundException;
import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.repository.MarcaRepository;
import com.cars.mycarsbackend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public List<MarcaDTO> findAll() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas.stream()
                .map(MarcaDTO::mapper)
                .collect(Collectors.toList());
    }

   @Override
    public MarcaDTO getById(Long id) {
       Marca marca = getMarcaById(id);
       return MarcaDTO.mapper(marca);
   }



    @Override
    public MarcaDTO updateMarca(MarcaDTO marcaDTO) {
        Marca marca = getMarcaById(marcaDTO.getId());
        marca.setNomeMarca(marcaDTO.getNomeMarca());
        marcaRepository.save(marca);
        return MarcaDTO.mapper(marca);
    }

    @Override
    public MarcaDTO createMarca(MarcaDTO marcaDTO) {
        Marca newMarca = new Marca();
        newMarca.setNomeMarca(marcaDTO.getNomeMarca());
        marcaRepository.save(newMarca);
        return MarcaDTO.mapper(newMarca);
    }

    @Override
    public void deleteMarca(Long id) {
        Marca marcaDel = getMarcaById(id);
        marcaRepository.delete(marcaDel);
    }


    private Marca getMarcaById(Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Marca id: " + id + " não encontrada."));
    }
}
