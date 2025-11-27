package com.xabi.xabi.repository;

import com.xabi.xabi.model.GrupoMuscular;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface GrupoMuscularRepository extends CrudRepository<GrupoMuscular , Long> {

    public List<GrupoMuscular> findAll();

    public Optional<GrupoMuscular> findById(Long id);

    public void deleteById(Long id);




}
