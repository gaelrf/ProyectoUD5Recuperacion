package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.repository.PersonalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalController {

    private final PersonalRepository personalRepository;

    public PersonalController(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @GetMapping("/")
    public String inicio(Model model){

        System.out.println('a');
        return "redirect:/personal";

    }

    @GetMapping("/personal")
    public String listaPersonal(){

        return "listaPersonal";

    }
}
