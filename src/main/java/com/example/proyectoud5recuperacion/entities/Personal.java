package com.example.proyectoud5recuperacion.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Personal {

    @Id
    ObjectId id;

    String nombre;

    String responsabilidad;

    float salario;

    @DBRef
    List<Paciente> pacientes;

}
