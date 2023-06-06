package com.example.proyectoud5recuperacion.repository;

import com.example.proyectoud5recuperacion.entities.Personal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalRepository extends MongoRepository<Personal, ObjectId> {

}
