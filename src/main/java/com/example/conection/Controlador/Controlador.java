package com.example.conection.Controlador;

import com.example.conection.DTO.DTO;
import com.example.conection.Modelo.*;
import com.example.conection.Servicios.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    private UsuarioService usuarioService;
    private String token = "trcyvubin";
    @GetMapping("/get/persona")
    public String getPersonas() throws JsonProcessingException {
        DTO dto = new DTO();
        dto.setPersona(personaServicio.traer());
        ObjectMapper cadena = new ObjectMapper();
        String json = cadena.writeValueAsString(dto.getPersona());
        return json;
    }
    @PostMapping("/crear/persona")
    public void crearPersona(@RequestBody Persona persona){
        personaServicio.crear(persona);
    }
    @GetMapping("/get/educacion")
    public String getEducaciones() throws JsonProcessingException {
        DTO dto = new DTO();
        dto.setEducacionList(educacionServicio.traer());
        ObjectMapper cadena = new ObjectMapper();
        String json = cadena.writeValueAsString(dto.getEducacionList());
        return json;
    }
    @GetMapping("/get/experiencia")
    public String getExperiencias() throws JsonProcessingException {
        DTO dto = new DTO();
        dto.setExperienciaList(experienciaServicio.traer());
        ObjectMapper cadena = new ObjectMapper();
        return cadena.writeValueAsString(dto.getExperienciaList());
    }
    @GetMapping("/get/proyecto")
    public String getProyectos() throws JsonProcessingException {
        DTO dto = new DTO();
        dto.setProyectoList(proyectoServicio.traer());
        ObjectMapper cadena = new ObjectMapper();
        return cadena.writeValueAsString(dto.getProyectoList());
    }
    @GetMapping("/get/skill")
    public String getSkills() throws JsonProcessingException {
        DTO dto = new DTO();
        dto.setSkillList(skillServicio.traer());
        ObjectMapper cadena = new ObjectMapper();
        return cadena.writeValueAsString(dto.getSkillList());
    }
    @PostMapping("/crear/educacion")
    public void crearEducacion(@RequestBody Educacion educacion){
        educacionServicio.crear(educacion);
    }
    @PostMapping("/crear/experiencia")
    public void crearExperiencia(@RequestBody Experiencia experiencia){
        experienciaServicio.crear(experiencia);
    }
    @PostMapping("/crear/proyecto")
    public void crearProyecto(@RequestBody Proyecto proyecto){
        proyectoServicio.crear(proyecto);
    }
    @PostMapping("/crear/skill")
    public void crearSkill(@RequestBody Skill skill){
        skillServicio.crear(skill);
    }
    @DeleteMapping("/borrar/educacion/{id}")
    public void borrarEducacion(@PathVariable long id){
        educacionServicio.eliminar(id);
    }
    @DeleteMapping("/borrar/proyecto/{id}")
    public void borrarProyecto(@PathVariable long id){
        proyectoServicio.eliminar(id);
    }
    @DeleteMapping("/borrar/experiencia/{id}")
    public void borrarExperiencia(@PathVariable long id){
        experienciaServicio.eliminar(id);
    }
    @DeleteMapping("/borrar/skill/{id}")
    public void borrarSkill(@PathVariable long id){
        skillServicio.eliminar(id);
    }
    @DeleteMapping("/borrar/persona/{id}")
    public void borrarPersona(@PathVariable long id){
        personaServicio.eliminar(id);
    }
    @PatchMapping("/editar/persona")
    public void editarPersona(@RequestBody Persona persona){
        personaServicio.editar(persona);
    }
    @PatchMapping("/editar/educacion")
    public void editarEducacion(@RequestBody Educacion educacion){
        educacionServicio.editar(educacion);
    }
    @PatchMapping("/editar/proyecto")
    public void editarProyecto(@RequestBody Proyecto proyecto){
        proyectoServicio.editar(proyecto);
    }
    @PatchMapping("/editar/skill")
    public void editarSkill(@RequestBody Skill skill){
        skillServicio.editar(skill);
    }
    @PatchMapping("/editar/experiencia")
    public void editarExperiencia(@RequestBody Experiencia experiencia){
        experienciaServicio.editar(experiencia);
    }
    @PostMapping("/login")
    public String iniciarSesion(@RequestBody Usuario usuario) throws JsonProcessingException {
        if(usuarioService.iniciarSesion(usuario)){
            Token token = new Token();
            ObjectMapper json = new ObjectMapper();
            return json.writeValueAsString(token);
        }else{
            return null;
        }
    }
    @PostMapping("/crear/usuario")
    public void crearUsuario(@RequestBody Usuario usuario){
        usuarioService.crear(usuario);
    }
}
