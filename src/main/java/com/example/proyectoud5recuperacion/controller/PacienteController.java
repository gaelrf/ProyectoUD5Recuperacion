package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.data.PacienteData;
import com.example.proyectoud5recuperacion.entities.Paciente;
import com.example.proyectoud5recuperacion.entities.Personal;
import com.example.proyectoud5recuperacion.services.PacienteService;
import com.example.proyectoud5recuperacion.services.PersonalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    PersonalService personalService;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/personal/{id}/paciente/nuevo")
    public String formNuevoPaciente(@PathVariable(value = "id") ObjectId idPersona, @ModelAttribute PacienteData pacienteData, Model model){

        model.addAttribute("idPersona", idPersona);

        return"formNuevoPaciente";

    }
    @PostMapping("/personal/{id}/paciente/nuevo")
    public String nuevoPaciente(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute PacienteData pacienteData){

        Personal persona = personalService.findPersonaById(idPersona);
        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteData.getNombre());
        paciente.setEdad(pacienteData.getEdad());
        paciente.setNuss(pacienteData.getNuss());
        pacienteService.nuevoPaciente(paciente);
        if (persona.getPacientes()==null){
            List<Paciente> pacientes = new ArrayList<>();
            pacientes.add(paciente);
            persona.setPacientes(pacientes);
        }else {
            persona.getPacientes().add(paciente);
        }
        personalService.modificarPersonal(persona);

        return"redirect:/personal/"+idPersona+"/visualizar";

    }


}
