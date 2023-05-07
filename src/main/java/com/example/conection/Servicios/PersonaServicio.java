package com.example.conection.Servicios;

import com.example.conection.Modelo.Persona;
import com.example.conection.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaServicio implements IPersona{
    @Autowired
    private PersonaRepositorio repositorio;
    @Override
    public void crear(Persona persona) {
        repositorio.save(persona);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Persona> traer() {
        return repositorio.findAll();
    }
}
