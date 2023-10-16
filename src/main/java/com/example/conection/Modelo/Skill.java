package com.example.conection.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "El campo 'nombre' no puede estar en blanco.")
    @Size(max = 255, message = "El campo 'nombre' no puede tener más de 255 caracteres.")
    @Column
    private String nombre;

    @NotBlank(message = "El campo 'porcentaje' no puede estar en blanco.")
    @Pattern(regexp = "^(100|[1-9]?[0-9])$", message = "El campo 'porcentaje' debe ser un número entre 0 y 100.")
    @Column
    private String porcentaje;
}