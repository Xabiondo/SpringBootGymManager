package com.xabi.xabi.controller;


import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.model.GrupoMuscular;
import com.xabi.xabi.repository.EjercicioRepository;
import com.xabi.xabi.service.EjercicioService;
import com.xabi.xabi.service.GrupoMuscularService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EjercicioRestController {

    @Autowired
    EjercicioService ejercicioService;


    @GetMapping("/ejercicios")
    public ResponseEntity<List<Ejercicio>> listarEjercicios(){
        List<Ejercicio> listaEjercicios  = ejercicioService.listarTodo();

        return  ResponseEntity.status(200).body(listaEjercicios);
    }
    @GetMapping("/ejercicios/{id}")
    public ResponseEntity<Optional<Ejercicio>> buscarEjercicio(@PathVariable Long id){

        Optional<Ejercicio> ejercicio = ejercicioService.buscarPorId(id);
        if (ejercicio.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ejercicio , HttpStatus.OK );
    }

    @GetMapping("/ejercicios")
    public List<Ejercicio> listarEjerciciosGrupo(@RequestParam(defaultValue = "grupo") String grupo){
        return ejercicioService.buscarPorGrupoMusuclar(grupo);


    }
    @PostMapping("/ejercicios")
    public ResponseEntity<Ejercicio> crearEjercicios(@Valid @RequestBody Ejercicio ejercicio){
        String dificultad = ejercicio.getDificultad().toLowerCase();
        if (dificultad == "principiante" || dificultad == "intermedio" || dificultad == "avanzado"){

            ejercicioService.guardar(ejercicio);

            return new ResponseEntity<>(ejercicio , HttpStatus.CREATED);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
    @PutMapping("/ejercicios/{id}")
    public ResponseEntity<Ejercicio> actualizarEjercicio(@PathVariable Long id  ,@Valid @RequestBody Ejercicio ejercicio){
        if (ejercicioService.buscarPorId(id).isEmpty()){
            return new ResponseEntity<Ejercicio>(HttpStatus.NOT_FOUND);

        }
        ejercicio.setId(id);
         ejercicioService.guardar(ejercicio);
         return new ResponseEntity<>(ejercicio , HttpStatus.OK);

    }
    @DeleteMapping("/ejercicios/{id}")
    public ResponseEntity<Boolean> borrarEjercicio(@PathVariable Long id){
        if (ejercicioService.buscarPorId(id).isEmpty()){

            return  new ResponseEntity<>(false , HttpStatus.NOT_FOUND);

        }
        ejercicioService.eliminar(id);
        return new ResponseEntity<>(true , HttpStatus.NO_CONTENT);


    }


}
