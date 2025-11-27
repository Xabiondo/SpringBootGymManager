package com.xabi.xabi.service;

import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {

    @Autowired
    EjercicioRepository ejercicioRepository;


    public List<Ejercicio> listarTodo(){
        return ejercicioRepository.findAll();

    }
    public Optional<Ejercicio> buscarPorId(Long id) {
        return ejercicioRepository.findById(id);

    }
    public Ejercicio guardar ( Ejercicio ejercicio){
        return ejercicioRepository.save(ejercicio);
    }
    public void eliminar ( Long id){
        ejercicioRepository.deleteById(id);
    }

    public List<Ejercicio>  buscarPorGrupoMusuclar(String nombre){
        return ejercicioRepository.findByGrupoMuscular_NombreIgnoreCase(nombre);
    }
    public Ejercicio actualizar (Long id , Ejercicio ejercicio){
        return ejercicioRepository.save(ejercicio);
    }

}
