package com.xabi.xabi.repository;

import com.xabi.xabi.model.Ejercicio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EjercicioRepository  extends CrudRepository<Ejercicio , Long> {

    public List<Ejercicio> findAll();

    public Optional<Ejercicio> findById(Long id);

    public List<Ejercicio> findByGrupoMuscular(String grupo);

    public void deleteById(Long id);

    public List<Ejercicio> findByGrupoMuscular_NombreIgnoreCase(String nombreGrupo);




}
