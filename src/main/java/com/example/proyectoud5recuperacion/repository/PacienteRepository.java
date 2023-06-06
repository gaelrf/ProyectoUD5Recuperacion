package com.example.proyectoud5recuperacion.repository;

import com.example.proyectoud5recuperacion.entities.Paciente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, ObjectId> {

}
