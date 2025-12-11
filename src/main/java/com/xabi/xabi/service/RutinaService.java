package com.xabi.xabi.service;

import com.xabi.xabi.model.Rutina;
import com.xabi.xabi.repository.EjercicioRepository;
import com.xabi.xabi.repository.RutinaEjercicioRepository;
import com.xabi.xabi.repository.RutinaRepository;

import java.util.List;
import java.util.Optional;

public class RutinaService {

    private final RutinaRepository rutinaRepository;
    private final RutinaEjercicioRepository rutinaEjercicioRepository;
    private final EjercicioRepository ejercicioRepository;

    public RutinaService(RutinaRepository rutinaRepository,
                         RutinaEjercicioRepository rutinaEjercicioRepository,
                         EjercicioRepository ejercicioRepository) {
        this.rutinaRepository = rutinaRepository;
        this.rutinaEjercicioRepository = rutinaEjercicioRepository;
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<Rutina> listarTodas(){
        return rutinaRepository.findAll();
    }

    public Optional<Rutina> buscarPorId(Long id) {
        return rutinaRepository.findById(id);
    }
    public Rutina guardarRutina(Rutina rutina){
        return rutinaRepository.save(rutina) ;

    }
    public void borrarPorId(Long id ){
         rutinaRepository.deleteById(id);
    }

}
