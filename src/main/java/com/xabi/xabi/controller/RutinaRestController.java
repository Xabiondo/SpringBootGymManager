package com.xabi.xabi.controller;


import com.xabi.xabi.model.Rutina;
import com.xabi.xabi.repository.RutinaRepository;
import com.xabi.xabi.service.RutinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaRestController {

    private final RutinaService rutinaService ;

    public RutinaRestController(RutinaService rutinaService){
        this.rutinaService = rutinaService ;
    }



    @GetMapping("")
    public ResponseEntity<List<Rutina>> listarRutinas(){
        List<Rutina> listaRutinas = rutinaService.listarTodas() ;
        return new ResponseEntity<>(listaRutinas , HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rutina>> buscarRutina(@PathVariable Long id){
        Optional<Rutina> rutina = rutinaService.buscarPorId(id);
        return new ResponseEntity<>(rutina , HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Rutina> crearRutina (Rutina rutina){
        return new ResponseEntity<>(rutina , HttpStatus.CREATED);

    }
}
