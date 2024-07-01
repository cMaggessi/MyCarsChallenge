package com.cars.mycarsbackend.repository;

import com.cars.mycarsbackend.model.Marca;
import com.cars.mycarsbackend.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByMarca(Marca marca);

}
