package com.example.conection.Servicios;

import com.example.conection.Modelo.Skill;

import java.util.List;

public interface ISkill {
    void crear(Skill skill);
    void eliminar(long id);
    List<Skill> traer();
    void editar(Skill skill);
}
