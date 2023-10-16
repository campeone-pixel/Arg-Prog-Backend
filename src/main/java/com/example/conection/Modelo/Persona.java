package com.example.conection.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Size(min = 3, max = 50, message = "El campo 'titulo_es' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'nombres' no puede estar en blanco.")
    @Column
    private String nombres;

    @Size(min = 3, max = 50, message = "El campo 'apellido' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'apellido' no puede estar en blanco.")
    @Column
    private String apellido;

    @Size(min = 3, max = 50, message = "El campo 'nacionalidad_es' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'nacionalidad_es' no puede estar en blanco.")
    @Column
    private String nacionalidad_es;

    @Size(min = 3, max = 50, message = "El campo 'nacionalidad_en' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'nacionalidad_en' no puede estar en blanco.")
    @Column
    private String nacionalidad_en;

    @Size(min = 3, max = 150, message = "El campo 'email' debe tener entre 3 y 150 caracteres.")
    @NotBlank(message = "El campo 'email' no puede estar en blanco.")
    @Email(message = "El campo 'email' debe ser una dirección de correo electrónico válida.")
    @Column
    private String email;

    @Size(min = 3, max = 300, message = "El campo 'sobre_mi_es' debe tener entre 3 y 300 caracteres.")
    @NotBlank(message = "El campo 'sobre_mi_es' no puede estar en blanco.")
    @Column
    private String sobre_mi_es;

    @Size(min = 3, max = 300, message = "El campo 'sobre_mi_en' debe tener entre 3 y 300 caracteres.")
    @NotBlank(message = "El campo 'sobre_mi_en' no puede estar en blanco.")
    @Column
    private String sobre_mi_en;

    @Size(min = 3, max = 50, message = "El campo 'ocupacion_es' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'ocupacion_es' no puede estar en blanco.")
    @Column
    private String ocupacion_es;

    @Size(min = 3, max = 50, message = "El campo 'ocupacion_en' debe tener entre 3 y 50 caracteres.")
    @NotBlank(message = "El campo 'ocupacion_en' no puede estar en blanco.")
    @Column
    private String ocupacion_en;

    @URL(message = "El campo 'image_background_header' debe ser una URL válida.")
    @Column
    private String image_background_header;

    @URL(message = "El campo 'image_perfil' debe ser una URL válida.")
    @Column
    private String image_perfil;

    @URL(message = "El campo 'image_sobre_mi' debe ser una URL válida.")
    @Column
    private String image_sobre_mi;
}