package com.example.conection.Servicios;

import com.example.conection.Modelo.Persona;
import com.example.conection.Repositorio.PersonaRepositorio;
import com.example.conection.Servicios.interfaces.IPersona;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonaServicio implements IPersona {
    @Autowired
    private PersonaRepositorio repositorio;
    @Override
    public void crear(Persona persona) {
        repositorio.save(persona);
    }

    @Override
    public void eliminar(long id) {
        Persona personaExistente = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con ID: " + id));
        repositorio.deleteById(id);
    }

    @Override
    public List<Persona> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Persona persona) {
        // Recuperar la persona existente por ID
        Persona personaExistente = repositorio.findById(persona.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la persona con ID: " + persona.getId()));

        // Actualizar las propiedades de la persona existente con los valores de la nueva persona
        personaExistente.setNombres(persona.getNombres());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setNacionalidad_es(persona.getNacionalidad_es());
        personaExistente.setNacionalidad_en(persona.getNacionalidad_en());
        personaExistente.setEmail(persona.getEmail());
        personaExistente.setSobre_mi_es(persona.getSobre_mi_es());
        personaExistente.setSobre_mi_en(persona.getSobre_mi_en());
        personaExistente.setOcupacion_es(persona.getOcupacion_es());
        personaExistente.setOcupacion_en(persona.getOcupacion_en());
        personaExistente.setImage_background_header(persona.getImage_background_header());
        personaExistente.setImage_perfil(persona.getImage_perfil());
        personaExistente.setImage_sobre_mi(persona.getImage_sobre_mi());

        // Guardar la persona existente actualizada
        repositorio.save(personaExistente);
    }
}
