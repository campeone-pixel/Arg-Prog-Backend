package com.example.conection.Servicios.interfaces;

import com.example.conection.Modelo.Experiencia;

import java.util.List;

public interface IExperiencia {
    void crear(Experiencia experiencia);
    void eliminar(long id);
    List<Experiencia> traer();
    void editar(Experiencia experiencia);
}