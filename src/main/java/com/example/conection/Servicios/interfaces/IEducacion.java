package com.example.conection.Servicios.interfaces;

import com.example.conection.Modelo.Educacion;

import java.util.List;

public interface IEducacion {
    void crear(Educacion educacion);
    void eliminar(long id);
    List<Educacion> traer();
    void editar(Educacion educacion);
}