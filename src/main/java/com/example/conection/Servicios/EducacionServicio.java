package com.example.conection.Servicios;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Repositorio.EducacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducacionServicio implements IEducacion{
    @Autowired
    private EducacionRepositorio repositorio;
    @Override
    public void crear(Educacion educacion) {
        repositorio.save(educacion);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Educacion> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Educacion educacion) {
        repositorio.deleteById(educacion.getId());
        repositorio.save(educacion);
    }
}
