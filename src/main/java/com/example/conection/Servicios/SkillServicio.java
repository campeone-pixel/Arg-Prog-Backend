package com.example.conection.Servicios;

import com.example.conection.Modelo.Skill;
import com.example.conection.Repositorio.SkillRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SkillServicio implements ISkill{
    @Autowired
    private SkillRepositorio repositorio;
    @Override
    public void crear(Skill skill) {
        repositorio.save(skill);
    }

    @Override
    public void eliminar(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Skill> traer() {
        return repositorio.findAll();
    }
}
