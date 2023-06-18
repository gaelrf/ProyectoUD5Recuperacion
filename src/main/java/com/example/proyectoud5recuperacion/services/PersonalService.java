package com.example.proyectoud5recuperacion.services;

import com.example.proyectoud5recuperacion.data.PersonalData;
import com.example.proyectoud5recuperacion.entities.Personal;
import com.example.proyectoud5recuperacion.repository.PersonalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }


    public List<Personal> allPersonal() {

        List<Personal> personal = personalRepository.findAll();
        return personal;

    }

    public void nuevoEmpleado(PersonalData personalData) {

        Personal empleado = new Personal();
        empleado.setNombre(personalData.getNombre());
        empleado.setResponsabilidad(personalData.getResponsabilidad());
        empleado.setSalario(personalData.getSalario());

        personalRepository.save(empleado);

    }

    public Personal findPersonaById(ObjectId idPersonal) {

        Personal persona =personalRepository.findById(idPersonal).orElse(null);
        return persona;

    }

    public void borrarPersona(ObjectId idPersonal) {

        personalRepository.deleteById(idPersonal);

    }

}
