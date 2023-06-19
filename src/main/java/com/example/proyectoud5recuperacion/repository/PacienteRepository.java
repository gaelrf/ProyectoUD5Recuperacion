package com.example.proyectoud5recuperacion.repository;

import com.example.proyectoud5recuperacion.entities.Paciente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PacienteRepository extends MongoRepository<Paciente, ObjectId> {

    List<Paciente> findByIdNotIn(List<ObjectId> ids);

}
