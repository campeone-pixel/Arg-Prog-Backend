package com.example.conection.Servicios;

import com.example.conection.Modelo.Experiencia;
import com.example.conection.Repositorio.ExperienciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExperienciaServicio implements IExperiencia{
    @Autowired
    private ExperienciaRepositorio repositorio;
    @Override
    public void crear(Experiencia experiencia) {
        repositorio.save(experiencia);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Experiencia> traer() {
        return repositorio.findAll();
    }
}
