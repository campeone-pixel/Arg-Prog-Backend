package com.example.conection.Servicios;

import com.example.conection.Modelo.Experiencia;
import com.example.conection.Repositorio.ExperienciaRepositorio;
import com.example.conection.Servicios.interfaces.IExperiencia;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienciaServicio implements IExperiencia {
    @Autowired
    private ExperienciaRepositorio repositorio;
    @Override
    public void crear(Experiencia experiencia) {
        repositorio.save(experiencia);
    }

    @Override
    public void eliminar(long id) {
        Experiencia experienciaExistente = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la experiencia con ID: " + id));

        repositorio.deleteById(id);
    }

    @Override
    public List<Experiencia> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Experiencia experiencia) {
        // Recuperar la experiencia existente por ID
        Experiencia experienciaExistente = repositorio.findById(experiencia.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la experiencia con ID: " + experiencia.getId()));

        // Actualizar las propiedades de la experiencia existente con los valores de la nueva experiencia
        experienciaExistente.setPuesto_es(experiencia.getPuesto_es());
        experienciaExistente.setPuesto_en(experiencia.getPuesto_en());
        experienciaExistente.setLugar(experiencia.getLugar());
        experienciaExistente.setDesde(experiencia.getDesde());
        experienciaExistente.setHasta(experiencia.getHasta());
        experienciaExistente.setEmpresa(experiencia.getEmpresa());
        experienciaExistente.setDescripcion_es(experiencia.getDescripcion_es());
        experienciaExistente.setDescripcion_en(experiencia.getDescripcion_en());

        // Guardar la experiencia existente actualizada
        repositorio.save(experienciaExistente);
    }
}
