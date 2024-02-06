package com.corenetworks.validaciones1.excepciones;


public class ExcepcionPersonalizadaNoEncontrado extends RuntimeException{
    public ExcepcionPersonalizadaNoEncontrado(String message) {
        super(message);
    }
}