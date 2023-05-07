package com.example.conection.DTO;

import com.example.conection.Modelo.*;
import com.example.conection.Servicios.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Getter@NoArgsConstructor
public class DTO {
    @Autowired
    private PersonaServicio personaServicio;
    @Autowired
    private EducacionServicio educacionServicio;
    @Autowired
    private ExperienciaServicio experienciaServicio;
    @Autowired
    private ProyectoServicio proyectoServicio;
    @Autowired
    private SkillServicio skillServicio;

    private final List<Persona> persona = personaServicio.traer();
    private final List<Educacion> educacionList = educacionServicio.traer();
    private final List<Experiencia> experienciaList = experienciaServicio.traer();
    private final List<Proyecto> proyectoList = proyectoServicio.traer();
    private final List<Skill> skillList = skillServicio.traer();
}
