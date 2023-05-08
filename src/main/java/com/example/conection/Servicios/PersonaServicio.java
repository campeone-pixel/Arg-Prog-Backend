package com.example.conection.Servicios;

import com.example.conection.Modelo.Persona;
import com.example.conection.Repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public void editar(Persona persona) {
        repositorio.deleteById(persona.getId());
        repositorio.save(persona);
    }
}
