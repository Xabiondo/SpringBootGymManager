package com.xabi.xabi.service;


import com.xabi.xabi.model.RutinaEjercicio;
import com.xabi.xabi.repository.EjercicioRepository;
import com.xabi.xabi.repository.RutinaEjercicioRepository;
import com.xabi.xabi.repository.RutinaRepository;

import java.util.List;

public class RutinaEjercicioService {

    private final RutinaRepository rutinaRepository ;
    private final RutinaEjercicioRepository rutinaEjercicioRepository;
    private final EjercicioRepository ejercicioRepository;

    public RutinaEjercicioService(RutinaRepository rutinaRepository,
                         RutinaEjercicioRepository rutinaEjercicioRepository,
                         EjercicioRepository ejercicioRepository) {
        this.rutinaRepository = rutinaRepository;
        this.rutinaEjercicioRepository = rutinaEjercicioRepository;
        this.ejercicioRepository = ejercicioRepository;
    }

    public List<RutinaEjercicio> listarRutinaEjercicio(){
        return rutinaEjercicioRepository.findAll();
    }
    public RutinaEjercicio añadirRutinaEjercicio(RutinaEjercicio rutinaEjercicio){
        return rutinaEjercicioRepository.save(rutinaEjercicio);

    }
    public void borrarRutinaEjercicio(Long id ){
         rutinaEjercicioRepository.deleteById(id);
    }









}
