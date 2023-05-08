package com.example.conection.Servicios;

import com.example.conection.Modelo.Proyecto;

import java.util.List;

public interface IProyecto {
    void crear(Proyecto proyecto);
    void eliminar(long id);
    List<Proyecto> traer();
    void editar(Proyecto proyecto);
}
