package com.example.conection.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "El campo 'escuela' no puede estar en blanco.")
    @Size(min = 3, max = 50, message = "El campo 'titulo_es' debe tener entre 3 y 50 caracteres.")
    @Column
    private String escuela;

    @NotBlank(message = "El campo 'titulo_es' no puede estar en blanco.")
    @Size(min = 3, max = 50, message = "El campo 'titulo_es' debe tener entre 3 y 50 caracteres.")
    @Column
    private String titulo_es;

    @NotBlank(message = "El campo 'titulo_en' no puede estar en blanco.")
    @Size(min = 3, max = 50, message = "El campo 'titulo_en' debe tener entre 3 y 50 caracteres.")
    @Column
    private String titulo_en;

    @NotBlank(message = "El campo 'imagen' no puede estar en blanco.")
    @URL(message = "El campo 'imagen' debe ser una URL válida.")
    @Column
    private String imagen;

    @NotBlank(message = "El campo 'carrera_es' no puede estar en blanco.")
    @Size(min = 3, max = 50, message = "El campo 'carrera_es' debe tener entre 3 y 50 caracteres.")
    @Column
    private String carrera_es;

    @NotBlank(message = "El campo 'carrera_en' no puede estar en blanco.")
    @Size(min = 3, max = 50, message = "El campo 'carrera_en' debe tener entre 3 y 50 caracteres.")
    @Column
    private String carrera_en;

    @NotBlank(message = "El campo 'inicio' no puede estar en blanco.")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de 'inicio' debe ser 'dd-mm-yyyy'.")
    @Column
    private String inicio;

    @NotBlank(message = "El campo 'fin' no puede estar en blanco.")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de 'fin' debe ser 'dd-mm-yyyy'.")
    @Column
    private String fin;
}
