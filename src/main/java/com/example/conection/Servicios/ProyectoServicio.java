package com.example.conection.Servicios;

import com.example.conection.Modelo.Proyecto;
import com.example.conection.Repositorio.ProyectoRepositorio;
import com.example.conection.Servicios.interfaces.IProyecto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProyectoServicio implements IProyecto {
    @Autowired
    private ProyectoRepositorio repositorio;
    @Override
    public void crear(Proyecto proyecto) {
        repositorio.save(proyecto);
    }

    @Override
    public void eliminar(long id) {
        Proyecto proyectoExistente = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el proyecto con ID: " + id));
        repositorio.deleteById(id);
    }

    @Override
    public List<Proyecto> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Proyecto proyecto) {
        // Recuperar el proyecto existente por ID, o lanzar una EntityNotFoundException si no se encuentra
        Proyecto proyectoExistente = repositorio.findById(proyecto.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el proyecto con ID: " + proyecto.getId()));

        // Actualizar las propiedades del proyecto existente con los valores del nuevo proyecto
        proyectoExistente.setNombre_es(proyecto.getNombre_es());
        proyectoExistente.setNombre_en(proyecto.getNombre_en());
        proyectoExistente.setDescripcion_es(proyecto.getDescripcion_es());
        proyectoExistente.setDescripcion_en(proyecto.getDescripcion_en());
        proyectoExistente.setLink(proyecto.getLink());
        proyectoExistente.setLink_foto(proyecto.getLink_foto());

        // Guardar el proyecto existente actualizado
        repositorio.save(proyectoExistente);
    }
}
