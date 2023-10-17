package com.example.conection.Servicios.interfaces;

import com.example.conection.Modelo.Persona;

import java.util.List;

public interface IPersona {
    void crear(Persona persona);
    void eliminar(long id);
    List<Persona> traer();
    void editar(Persona persona);
}