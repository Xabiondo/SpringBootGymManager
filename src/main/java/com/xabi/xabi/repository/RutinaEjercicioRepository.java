package com.xabi.xabi.repository;

import com.xabi.xabi.model.RutinaEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutinaEjercicioRepository extends JpaRepository<RutinaEjercicio , Long> {
    List<RutinaEjercicio> findByRutinaId(Long rutinaId);
}
