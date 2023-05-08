package com.example.conection.Servicios;

import com.example.conection.Modelo.Proyecto;
import com.example.conection.Repositorio.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoServicio implements IProyecto{
    @Autowired
    private ProyectoRepositorio repositorio;
    @Override
    public void crear(Proyecto proyecto) {
        repositorio.save(proyecto);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Proyecto> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Proyecto proyecto) {
        repositorio.deleteById(proyecto.getId());
        repositorio.save(proyecto);
    }
}
