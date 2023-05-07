package com.example.conection.Controlador;

import com.example.conection.DTO.DTO;
import com.example.conection.Modelo.*;
import com.example.conection.Servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Controlador {
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
    @GetMapping("/get/persona")
    public List<Persona> getPersonas(){
        DTO dto = new DTO();
        return dto.getPersona();
    }
    @GetMapping("/get/educacion")
    public List<Educacion> getEducaciones(){
        DTO dto = new DTO();
        return dto.getEducacionList();
    }
    @GetMapping("/get/experiencia")
    public List<Experiencia> getExperiencias(){
        DTO dto = new DTO();
        return dto.getExperienciaList();
    }
    @GetMapping("/get/proyecto")
    public List<Proyecto> getProyectos(){
        DTO dto = new DTO();
        return dto.getProyectoList();
    }
    @GetMapping("/get/skill")
    public List<Skill> getSkills(){
        DTO dto = new DTO();
        return dto.getSkillList();
    }
    @PostMapping("/crear/educacion")
    public void crearEducacion(Educacion educacion){

    }
    @PostMapping("/crear/experiencia")
    public void crearExperiencia(Experiencia experiencia){

    }
    @PostMapping("/crear/proyecto")
    public void crearProyecto(Proyecto proyecto){

    }
    @PostMapping("/crear/skill")
    public void crearSkill(Skill skill){

    }
    @DeleteMapping("/")
    public void borrarEducacion(long id){

    }
    @DeleteMapping("/")
    public void borrarProyecto(long id){

    }
    @DeleteMapping("/")
    public void borrarExperiencia(long id){

    }
    @DeleteMapping("/")
    public void borrarSkill(long id){

    }

}
