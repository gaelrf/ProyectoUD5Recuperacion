package com.example.proyectoud5recuperacion.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Personal {

    @Id
    ObjectId id;
}
