package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.repository.PersonalRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

        return "listaVinos";

    }
}
