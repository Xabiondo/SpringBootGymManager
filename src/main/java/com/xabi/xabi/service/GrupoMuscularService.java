package com.xabi.xabi.service;


import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.model.GrupoMuscular;
import com.xabi.xabi.repository.GrupoMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoMuscularService {

    @Autowired
    GrupoMuscularRepository grupoMuscularRepository;

    public List<GrupoMuscular> listarTodo(){
        return grupoMuscularRepository.findAll();
    }

    public Optional<GrupoMuscular> buscarPorId(Long id){
        return grupoMuscularRepository.findById(id);

    }

    public GrupoMuscular guardar(GrupoMuscular grupoMuscular){
        return grupoMuscularRepository.save(grupoMuscular);
    }

    public void eliminar(Long id){
        grupoMuscularRepository.deleteById(id);
    }





}
