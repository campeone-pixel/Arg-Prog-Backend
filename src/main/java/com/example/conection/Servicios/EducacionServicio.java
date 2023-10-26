package com.example.conection.Servicios;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Repositorio.EducacionRepositorio;
import com.example.conection.Servicios.interfaces.IEducacion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducacionServicio implements IEducacion {
    @Autowired
    private EducacionRepositorio repositorio;
    @Override
    public void crear(Educacion educacion) {
        repositorio.save(educacion);
    }

    @Override
    public void eliminar(long id) {
        Educacion educacionExistente = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la educación con ID: " + id));

        repositorio.deleteById(id);
    }

    @Override
    public List<Educacion> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Educacion educacion) {
        // Recuperar la educación existente por ID
        Educacion educacionExistente = repositorio.findById(educacion.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la educación con ID: " + educacion.getId()));

        // Actualizar las propiedades de la educación existente con los valores de la nueva educación
        educacionExistente.setEscuela(educacion.getEscuela());
        educacionExistente.setTitulo_es(educacion.getTitulo_es());
        educacionExistente.setTitulo_en(educacion.getTitulo_en());
        educacionExistente.setImagen(educacion.getImagen());
        educacionExistente.setCarrera_es(educacion.getCarrera_es());
        educacionExistente.setCarrera_en(educacion.getCarrera_en());
        educacionExistente.setInicio(educacion.getInicio());
        educacionExistente.setFin(educacion.getFin());

        // Guardar la educación existente actualizada
        repositorio.save(educacionExistente);
    }
}
