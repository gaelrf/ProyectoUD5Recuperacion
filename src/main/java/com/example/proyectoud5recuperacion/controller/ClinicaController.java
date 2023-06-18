package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.data.ClinicaData;
import com.example.proyectoud5recuperacion.entities.Clinica;
import com.example.proyectoud5recuperacion.entities.Personal;
import com.example.proyectoud5recuperacion.services.PersonalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClinicaController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/personal/{id}/clinica/nueva")
    public String formNuevaClinica(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute ClinicaData clinicaData, Model model){

        model.addAttribute("idPersona", idPersona);

        return"formNuevaClinica";

    }
    @PostMapping("/personal/{id}/clinica/nueva")
    public String nuevaClinica(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute ClinicaData clinicaData){

        Personal persona = personalService.findPersonaById(idPersona);
        Clinica clinica = new Clinica();
        clinica.setNumero(clinicaData.getNumero());
        clinica.setUso(clinicaData.getUso());
        clinica.setTamanho(clinicaData.getTamanho());
        persona.setClinica(clinica);
        personalService.modificarPersonal(persona);

        return"redirect:/personal/"+idPersona+"/visualizar";

    }

    @GetMapping("/personal/{id}/clinica/modificar")
    public String formModificarClinica(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute ClinicaData clinicaData, Model model){

        Clinica clinica = personalService.findPersonaById(idPersona).getClinica();
        clinicaData.setNumero(clinica.getNumero());
        clinicaData.setUso(clinica.getUso());
        clinicaData.setTamanho(clinica.getTamanho());
        model.addAttribute("clinicaData",clinicaData);
        model.addAttribute("idPersona",idPersona);

        return"formNuevaClinica";

    }

    @PostMapping("/personal/{id}/clinica/modificar")
    public String modificarClinica(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute ClinicaData clinicaData){

        Personal persona = personalService.findPersonaById(idPersona);
        Clinica clinica = new Clinica();
        clinica.setNumero(clinicaData.getNumero());
        clinica.setUso(clinicaData.getUso());
        clinica.setTamanho(clinicaData.getTamanho());
        persona.setClinica(clinica);
        personalService.modificarPersonal(persona);

        return"redirect:/personal/"+idPersona+"/visualizar";

    }

    @DeleteMapping("/personal/{id}/clinica/borrar")
    public String borrarClinica(@PathVariable(value = "id")ObjectId idPersona){

        System.out.println("a");
        Personal persona = personalService.findPersonaById(idPersona);
        persona.setClinica(null);
        personalService.modificarPersonal(persona);
        return "";

    }

    @GetMapping("personal/{id}/clinica/visualizar")
    public String personalDetalles(@PathVariable(value = "id") ObjectId personaId, Model model){

        Personal persona = personalService.findPersonaById(personaId);
        model.addAttribute("clinica", persona.getClinica());
        model.addAttribute("personaId", personaId);

        return"detallesConsulta";


    }
}
