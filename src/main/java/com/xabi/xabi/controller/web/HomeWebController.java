package com.xabi.xabi.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController {

    @GetMapping("/web")
    public String vistaPrincipal(Model model){
        return "home" ;

    }
}
