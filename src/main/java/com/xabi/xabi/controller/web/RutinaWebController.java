package com.xabi.xabi.controller.web;

import com.xabi.xabi.model.Ejercicio;
import com.xabi.xabi.model.Rutina;
import com.xabi.xabi.model.RutinaEjercicio;
import com.xabi.xabi.service.EjercicioService;
import com.xabi.xabi.service.RutinaEjercicioService;
import com.xabi.xabi.service.RutinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/web/rutinas")
public class RutinaWebController {

    private final RutinaService rutinaService;
    private final EjercicioService ejercicioService;
    private final RutinaEjercicioService rutinaEjercicioService ;

    public RutinaWebController(RutinaService rutinaService,
                               EjercicioService ejercicioService ,
                               RutinaEjercicioService rutinaEjercicioService) {
        this.rutinaService = rutinaService;
        this.ejercicioService = ejercicioService;
        this.rutinaEjercicioService = rutinaEjercicioService ;
    }

    @GetMapping
    public String listarRutinas(Model model) {
        List<Rutina> rutinas = rutinaService.listarTodas();
        model.addAttribute("rutinas", rutinas);
        return "rutinas-list";
    }

    @GetMapping("/nueva")
    public String formularioNuevaRutina(Model model) {
        model.addAttribute("rutina", new Rutina());
        List<String> niveles = List.of("Principiante", "Intermedio", "Avanzado");
        model.addAttribute("niveles", niveles);
        return "rutina-form";
    }

    @PostMapping("/guardar")
    public String guardarRutina(Rutina rutina) {
        rutinaService.guardarRutina(rutina);
        return "redirect:/web/rutinas";
    }

    @GetMapping("/{id}/editar")
    public String formularioEditarRutina(@PathVariable Long id, Model model) {
        Optional<Rutina> rutina = rutinaService.buscarPorId(id);

        if (rutina.isEmpty()) {
            return "redirect:/web/rutinas";
        }

        model.addAttribute("rutina", rutina.get());
        List<String> niveles = List.of("Principiante", "Intermedio", "Avanzado");
        model.addAttribute("niveles", niveles);
        return "rutina-form";
    }

    @GetMapping("/{id}/borrar")
    public String borrarRutina(@PathVariable Long id) {
        rutinaService.borrarPorId(id);
        return "redirect:/web/rutinas";
    }

    @GetMapping("/{id}")
    public String detalleRutina(@PathVariable Long id, Model model) {
        Optional<Rutina> rutina = rutinaService.buscarPorId(id);

        if (rutina.isEmpty()) {
            return "redirect:/web/rutinas";
        }

        model.addAttribute("rutina", rutina.get());
        return "rutina-detalle";
    }
    @GetMapping("/ejercicioRutina/nuevo")
    public String añadirEjercicioRutina( Model model){
        List<Ejercicio> ejercicios = ejercicioService.listarTodo();
        List<Rutina> rutinas = rutinaService.listarTodas();
        model.addAttribute("ejercicios" , ejercicios);
        model.addAttribute("rutinas" , rutinas);
        model.addAttribute("rutinaEjercicio" , new RutinaEjercicio());

        return "rutina-añadir-ejercicio";

    }
    @PostMapping("/ejercicioRutina/nuevo")
    public  String añadirEjercicioARutina(RutinaEjercicio rutinaEjercicio){
        rutinaEjercicioService.añadirRutinaEjercicio(rutinaEjercicio) ;
        return "redirect:/web/rutinas" ;



    }
}