package com.example.conection.Servicios;

import com.example.conection.Modelo.Skill;
import com.example.conection.Repositorio.SkillRepositorio;
import com.example.conection.Servicios.interfaces.ISkill;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkillServicio implements ISkill {
    @Autowired
    private SkillRepositorio repositorio;
    @Override
    public void crear(Skill skill) {
        repositorio.save(skill);
    }

    @Override
    public void eliminar(long id) {
        Skill skillExistente = repositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la skill con ID: " + id));

        repositorio.deleteById(id)
        ;
    }

    @Override
    public List<Skill> traer() {
        return repositorio.findAll();
    }

    @Override
    public void editar(Skill skill) {
        // Recuperar la skill existente por ID, o lanzar una EntityNotFoundException si no se encuentra
        Skill skillExistente = repositorio.findById(skill.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la skill con ID: " + skill.getId()));

        // Actualizar las propiedades de la skill existente con los valores de la nueva skill
        skillExistente.setNombre(skill.getNombre());
        skillExistente.setPorcentaje(skill.getPorcentaje());

        // Guardar la skill existente actualizada
        repositorio.save(skillExistente);
    }
}
