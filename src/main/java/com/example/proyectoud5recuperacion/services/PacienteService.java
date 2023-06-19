package com.example.proyectoud5recuperacion.services;

import com.example.proyectoud5recuperacion.entities.Paciente;
import com.example.proyectoud5recuperacion.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
