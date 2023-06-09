package com.example.proyectoud5recuperacion.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Paciente {

    @Id
    private ObjectId id;

    private String nombre;

    private String nuss;

    private int edad;

    public ObjectId getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNuss() {
        return nuss;
    }

    public void setNuss(String nuss) {
        this.nuss = nuss;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
