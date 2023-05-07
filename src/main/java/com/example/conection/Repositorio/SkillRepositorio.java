package com.example.conection.Repositorio;

import com.example.conection.Modelo.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepositorio extends JpaRepository<Skill,Long> {
}
