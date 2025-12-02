package com.xabi.xabi.controller.web;


import com.xabi.xabi.model.GrupoMuscular;
import com.xabi.xabi.service.GrupoMuscularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class GrupoMuscularWebController {

    public GrupoMuscularWebController(GrupoMuscularService grupoMuscularService){
        this.grupoMuscularService = grupoMuscularService;
    }

    @Autowired
    GrupoMuscularService grupoMuscularService ;

    @GetMapping("/web/grupos")
    public String gruposPlantilla(Model model){

        List<GrupoMuscular> lista = grupoMuscularService.listarTodo();
        model.addAttribute("grupos" , lista);

        return "grupos-list";

    }
    @PostMapping("/web/grupos/nuevo")
    public  String formularioPlantillaEnviar(GrupoMuscular grupoMuscular){
        grupoMuscularService.guardar(grupoMuscular);
        return "redirect:/web/grupos";

    }
    @GetMapping("/web/grupos/nuevo")
    public  String formularioPlantilla(Model model){
        model.addAttribute("grupoMuscular", new GrupoMuscular());

        return "grupo-form";
    }

    @GetMapping("/web/grupos/{id}/editar")
    public  String buscarPorId(Model model , @PathVariable Long id ){

        Optional<GrupoMuscular> grupoMuscular = grupoMuscularService.buscarPorId(id);

        if (grupoMuscular.isEmpty()){
            return "redirect:/web/grupos/nuevo";

        }
        model.addAttribute("grupoMuscular" , grupoMuscular);
        return "grupo-form";

    }

    @GetMapping("/web/grupos/{id}/borrar")
    public String borrarId(Model model , @PathVariable Long id){
        grupoMuscularService.eliminar(id);
        return "redirect:/web/grupos";


    }


}
