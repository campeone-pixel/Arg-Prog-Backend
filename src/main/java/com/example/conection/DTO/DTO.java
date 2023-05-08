package com.example.conection.DTO;

import com.example.conection.Modelo.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter@NoArgsConstructor@Setter
public class DTO {

    private List<Persona> persona;
    private List<Educacion> educacionList;
    private List<Experiencia> experienciaList;
    private List<Proyecto> proyectoList;
    private List<Skill> skillList;
}
