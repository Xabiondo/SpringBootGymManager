package com.xabi.xabi.controller.web;


import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.model.GrupoMuscular;
import com.xabi.xabi.service.EjercicioService;
import com.xabi.xabi.service.GrupoMuscularService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class EjercicioWebController {

    private final EjercicioService ejercicioService;

    private final GrupoMuscularService grupoMuscularService ;

    public EjercicioWebController(EjercicioService ejercicioService ,
                                  GrupoMuscularService grupoMuscularService){
        this.ejercicioService = ejercicioService ;
        this.grupoMuscularService = grupoMuscularService  ;

    }

    @GetMapping("/web/ejercicios")
    public String verEjercicios(Model model){

        List<Ejercicio> ejercicios = ejercicioService.listarTodo() ;
        model.addAttribute("ejercicios" , ejercicios) ;

        return "ejercicios" ;

    }
    @GetMapping("/web/ejercicio/nuevo")
    public String verFormularioEjercicio(Model model){
        model.addAttribute("ejercicio" , new Ejercicio()) ;
        List<GrupoMuscular> opciones = grupoMuscularService.listarTodo() ;
        model.addAttribute("opciones" , opciones) ;
        List<String> dificultades =
                List.of("PRINCIPIANTE", "INTERMEDIO", "AVANZADO");
        model.addAttribute("dificultades" , dificultades) ;

        return "ejercicio-form";

    }
    @PostMapping("/web/ejercicio/nuevo")
    public String guardarEjercicio (Ejercicio ejercicio ){
        ejercicioService.guardar(ejercicio) ;



        return "redirect:/web/ejercicios" ;
    }
    @GetMapping("/web/ejercicio/{id}/editar")
    public String verEjercicio(@PathVariable Long id , Model model){
        Optional<Ejercicio> ejercicio = ejercicioService.buscarPorId(id);

        if (ejercicio.isEmpty()){

            return  "redirect:/web/ejercicios" ;
        }
        model.addAttribute("ejercicio" , ejercicio);
        List<GrupoMuscular> opciones = grupoMuscularService.listarTodo() ;
        model.addAttribute("opciones" , opciones) ;
        List<String> dificultades =
                List.of("PRINCIPIANTE", "INTERMEDIO", "AVANZADO");
        model.addAttribute("dificultades" , dificultades) ;

        return "ejercicio-form";


    }
    @GetMapping("/web/ejercicio/{id}/borrar")
    public String borrarEjercicio(@PathVariable Long id  ){
        ejercicioService.eliminar(id);
        return "redirect:/web/ejercicios";

    }
}
