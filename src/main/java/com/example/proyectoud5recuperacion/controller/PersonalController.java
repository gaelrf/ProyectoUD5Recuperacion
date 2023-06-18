package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.data.PersonalData;
import com.example.proyectoud5recuperacion.entities.Personal;
import com.example.proyectoud5recuperacion.services.PersonalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalController {

    @Autowired
    PersonalService personalService;

    @GetMapping("/")
    public String inicio(){

        return "redirect:/personal";

    }

    @GetMapping("/personal")
    public String listaPersonal(Model model){

        List<Personal> personal = personalService.allPersonal();
        model.addAttribute( "personal",personal);
        return "listaPersonal";

    }

    @GetMapping("/personal/nuevo")
    public String formNuevoPersonal(@ModelAttribute PersonalData personalData, Model model) {

        return "formNuevoPersonal";

    }

    @PostMapping("/personal/nuevo")
    public String nuevoPersonal(@ModelAttribute PersonalData personalData, RedirectAttributes flash){

        personalService.nuevoEmpleado(personalData);

        return "redirect:/personal";

    }

    @DeleteMapping("personal/{id}")
    @ResponseBody
    public String personalDelete(@PathVariable(value="id") ObjectId idPersonal){

        Personal personal = personalService.findPersonaById(idPersonal);

        if (personal==null){


        }

        personalService.borrarPersona(idPersonal);

        return "";

    }

    @GetMapping("personal/{id}/visualizar")
    public String personalDetalles(@PathVariable(value = "id") ObjectId idPersonal, Model model){

        Personal persona = personalService.findPersonaById(idPersonal);
        model.addAttribute("persona", persona);

        return"detallesPersonal";


    }

    @GetMapping("personal/{id}/modificar")
    public String formPersonalModificar(@PathVariable(value = "id") ObjectId idPersonal,@ModelAttribute PersonalData personaData, Model model){

        Personal persona = personalService.findPersonaById(idPersonal);
        model.addAttribute("persona",persona);
        personaData.setNombre(persona.getNombre());
        personaData.setResponsabilidad(persona.getResponsabilidad());
        personaData.setSalario(persona.getSalario());
        model.addAttribute("personaData",personaData);

        return"formModificarPersonal";

    }

    @PostMapping("personal/{id}/modificar")
    public String personalModificar(@PathVariable(value = "id") ObjectId idPersonal, @ModelAttribute PersonalData personaData, Model model){

        Personal empleado = personalService.findPersonaById(idPersonal);
        empleado.setNombre(personaData.getNombre());
        empleado.setResponsabilidad(personaData.getResponsabilidad());
        empleado.setSalario(personaData.getSalario());
        personalService.modificarPersonal(empleado);

        return"redirect:/personal/"+ idPersonal +"/visualizar";
    }

}
