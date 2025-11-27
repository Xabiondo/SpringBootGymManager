package com.xabi.xabi.controller;


import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.model.GrupoMuscular;
import com.xabi.xabi.service.GrupoMuscularService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GrupoMuscularRestController {

    @Autowired
    GrupoMuscularService grupoMuscularService;



    @GetMapping("/grupos")
    public ResponseEntity<List<GrupoMuscular>> listarGrupoMuscular(){
        List<GrupoMuscular> listaEjercicios = grupoMuscularService.listarTodo();
        return new ResponseEntity<>(listaEjercicios , HttpStatus.OK);

    }

    @GetMapping("/grupos/{id}")
    public ResponseEntity<Optional<GrupoMuscular>> grupoMuscular(@PathVariable Long id){
        Optional<GrupoMuscular> respuesta =  grupoMuscularService.buscarPorId(id);
        return new ResponseEntity<>(respuesta , HttpStatus.OK);
    }
    @PostMapping("/grupos")
    public ResponseEntity<GrupoMuscular> crearGrupoMuscular(@Valid  @RequestBody GrupoMuscular grupoMuscular){
        GrupoMuscular grupoMuscular1 =  grupoMuscularService.guardar(grupoMuscular);
        return new ResponseEntity<>(grupoMuscular1 , HttpStatus.CREATED) ;

    }
    @PutMapping("/grupos/{id}")
    public ResponseEntity<GrupoMuscular> actualizarGrupoMuscular(@PathVariable Long id ,@Valid @RequestBody GrupoMuscular grupoMuscular){
        List<GrupoMuscular> grupoMusculars = grupoMuscularService.listarTodo();

        if (grupoMusculars.contains(grupoMuscular)){
            grupoMuscularService.guardar(grupoMuscular);
            return new ResponseEntity<>(grupoMuscular , HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/grupos/{id}")
    public ResponseEntity<Boolean> eliminarGrupoMuscular(@PathVariable  Long id){
        List<GrupoMuscular> grupoMusculars = grupoMuscularService.listarTodo();

        for (GrupoMuscular grupoMuscular: grupoMusculars){
            if (grupoMuscular.getId() == id){
                grupoMuscularService.eliminar(id);
                return new ResponseEntity<>(true , HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(false , HttpStatus.NOT_FOUND);

    }

}
