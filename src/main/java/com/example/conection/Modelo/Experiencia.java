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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Size(min = 3, max = 50, message = "El campo 'puesto_es' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'puesto_es' no puede estar en blanco.")
    @Column
    private String puesto_es;

    @Size(min = 3, max = 50, message = "El campo 'puesto_en' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'puesto_en' no puede estar en blanco.")
    @Column
    private String puesto_en;

    @Size(min = 3, max = 50, message = "El campo 'lugar' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'lugar' no puede estar en blanco.")
    @Column
    private String lugar;


    @NotBlank(message = "El campo 'desde' no puede estar en blanco.")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de 'desde' debe ser 'dd-mm-yyyy'.")
    @Column
    private String desde;

    @NotBlank(message = "El campo 'hasta' no puede estar en blanco.")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "El formato de 'hasta' debe ser 'dd-mm-yyyy'.")
    @Column
    private String hasta;

    @Size(min = 3, max = 50, message = "El campo 'empresa' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'empresa' no puede estar en blanco.")
    @Column
    private String empresa;

    @Size(min = 3, max = 50, message = "El campo 'descripcion_es' debe tener entre 3 y 150 caracteres.")
    @NotBlank(message = "El campo 'descripcion_es' no puede estar en blanco.")
    @Column
    private String descripcion_es;

    @Size(min = 3, max = 50, message = "El campo 'descripcion_en' debe tener entre 3 y 150 caracteres.")
    @NotBlank(message = "El campo 'descripcion_en' no puede estar en blanco.")
    @Column
    private String descripcion_en;
}
