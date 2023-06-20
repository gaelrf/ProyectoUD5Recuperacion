package com.example.proyectoud5recuperacion.controller;

import com.example.proyectoud5recuperacion.data.ClinicaData;
import com.example.proyectoud5recuperacion.data.PacienteData;
import com.example.proyectoud5recuperacion.entities.Clinica;
import com.example.proyectoud5recuperacion.entities.Paciente;
import com.example.proyectoud5recuperacion.entities.Personal;
import com.example.proyectoud5recuperacion.services.PacienteService;
import com.example.proyectoud5recuperacion.services.PersonalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/personal/{id}/paciente/{index}")
    public String quitarBorrarPaciente(@PathVariable(value = "id")ObjectId idPersona, @PathVariable(value = "index")int index){

        Personal persona = personalService.findPersonaById(idPersona);
        pacienteService.borrarPaciente(persona.getPacientes().get(index));

        return "";

    }

    @GetMapping("/personal/{id}/paciente/{index}/quitar")
    public String quitarPaciente(@PathVariable(value = "id")ObjectId idPersona, @PathVariable(value = "index")int index){

        Personal persona = personalService.findPersonaById(idPersona);
        persona.getPacientes().remove(index);
        personalService.modificarPersonal(persona);

        return "redirect:/personal/"+idPersona+"/visualizar";

    }
    @GetMapping("/personal/{id}/paciente/listar")
    public String listarPaciente(@PathVariable(value = "id") ObjectId idPersona, @ModelAttribute PacienteData pacienteData, Model model){

        Personal personal = personalService.findPersonaById(idPersona);
        List<Paciente> pacientes = new ArrayList<>();
        if (personal.getPacientes()!=null) {
            pacientes = pacienteService.listarPacientes(personal.getPacientes());
        }else {
            pacientes = pacienteService.listarPacientes(pacientes);

        }

        model.addAttribute("pacientes", pacientes);
        model.addAttribute("idPersona", idPersona);

        return"añadirPaciente";

    }
    @GetMapping("/personal/{id}/paciente/anhadir/{idPaciente}")
    public String añadirPaciente(@PathVariable(value = "id") ObjectId idPersona,@PathVariable(value = "idPaciente")ObjectId idPaciente, @ModelAttribute PacienteData pacienteData, Model model){

        Personal persona = personalService.findPersonaById(idPersona);
        Paciente paciente = pacienteService.findPacienteById(idPaciente);
        if (persona.getPacientes()==null){
            List<Paciente> pacientes = new ArrayList<>();
            pacientes.add(paciente);
            persona.setPacientes(pacientes);
        }else {
            persona.getPacientes().add(paciente);
        }
        System.out.println(persona.getPacientes());
        personalService.modificarPersonal(persona);


        return"redirect:/personal/"+idPersona+"/paciente/listar";

    }

    @GetMapping("/personal/{id}/paciente/{idPaciente}")
    public String detallesPaciente(@PathVariable(value = "id")ObjectId idPersona,@PathVariable(value = "idPaciente") ObjectId idPaciente){


        return "detallesPaciente";

    }

    @GetMapping("/personal/{id}/paciente/modificar")
    public String formModificarClinica(@PathVariable(value = "id")ObjectId idPersona,@PathVariable(value = "idPaciente") ObjectId idPaciente ,@ModelAttribute PacienteData pacienteData, Model model){

        Paciente paciente = pacienteService.findPacienteById(idPaciente);
        pacienteData.setNombre(paciente.getNombre());
        pacienteData.setNuss(paciente.getNuss());
        pacienteData.setEdad(paciente.getEdad());
        model.addAttribute("clinicaData",pacienteData);
        model.addAttribute("idPersona",idPersona);

        return"formNuevaClinica";

    }

    @PostMapping("/personal/{id}/paciente/modificar")
    public String modificarClinica(@PathVariable(value = "id")ObjectId idPersona, @ModelAttribute PacienteData pacienteData){

        Personal persona = personalService.findPersonaById(idPersona);
        Paciente paciente = new Clinica();
        clinica.setNumero(clinicaData.getNumero());
        clinica.setUso(clinicaData.getUso());
        clinica.setTamanho(clinicaData.getTamanho());
        pacienteService.nuevoPaciente(paciente);

        return"redirect:/personal/"+idPersona+"/visualizar";

    }

}
