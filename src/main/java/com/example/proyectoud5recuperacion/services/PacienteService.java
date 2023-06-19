package com.example.proyectoud5recuperacion.services;

import com.example.proyectoud5recuperacion.entities.Paciente;
import com.example.proyectoud5recuperacion.repository.PacienteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void nuevoPaciente(Paciente paciente){

        pacienteRepository.save(paciente);

    }

    public void borrarPaciente(Paciente paciente){

        pacienteRepository.delete(paciente);

    }

    public List<Paciente> listarPacientes(List<Paciente> pacientes){

        List<ObjectId> ids = new ArrayList<>();
        for ( Paciente paciente: pacientes){

            ids.add(paciente.getId());

        }
        return pacienteRepository.findByIdNotIn(ids);

    }

    public Paciente findPacienteById(ObjectId idPaciente) {

        return pacienteRepository.findById(idPaciente).orElse(null);

    }
}
