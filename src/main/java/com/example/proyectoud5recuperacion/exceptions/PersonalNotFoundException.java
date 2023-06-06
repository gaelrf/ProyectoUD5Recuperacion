package com.example.proyectoud5recuperacion.exceptions;

public class PersonalNotFoundException extends RuntimeException{
    public PersonalNotFoundException(String message) {
        super("Empleado no encontrado: " +message);
    }
}
