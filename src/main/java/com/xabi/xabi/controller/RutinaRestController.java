package com.xabi.xabi.controller;


import com.xabi.xabi.model.Rutina;
import com.xabi.xabi.model.RutinaEjercicio;
import com.xabi.xabi.repository.RutinaRepository;
import com.xabi.xabi.service.RutinaEjercicioService;
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

    private final RutinaEjercicioService rutinaEjercicioService ;

    public RutinaRestController(RutinaService rutinaService , RutinaEjercicioService rutinaEjercicioService){
        this.rutinaService = rutinaService ;
        this.rutinaEjercicioService =  rutinaEjercicioService ;
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
    public ResponseEntity<Rutina> crearRutina (@RequestBody  Rutina rutina){
        rutinaService.guardarRutina(rutina);
        return new ResponseEntity<>(rutina , HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Rutina> actualizarRutina (@RequestBody  Rutina rutina ,@PathVariable Long id ){
        if (rutinaService.buscarPorId(id).isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
        rutina.setId(id);
        rutinaService.guardarRutina(rutina);
        return new ResponseEntity<>(rutina , HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Rutina> borrarRutina (@PathVariable Long id){

        if (rutinaService.buscarPorId(id).isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }

        rutinaService.borrarPorId(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/ejercicios")
    public  ResponseEntity<List<RutinaEjercicio>> listarEjerciciosRutina (@PathVariable Long id ){
       List<RutinaEjercicio>  ejerciciosRutina = rutinaEjercicioService.encontrarEjerciciosRutina(id);

        return new ResponseEntity<>(ejerciciosRutina , HttpStatus.OK);


    }
}
