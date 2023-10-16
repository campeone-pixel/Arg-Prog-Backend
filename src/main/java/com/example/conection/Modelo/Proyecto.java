package com.example.conection.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "El campo 'nombre_es' no puede estar en blanco.")
    @Size(max = 255, message = "El campo 'nombre_es' no puede tener más de 255 caracteres.")
    @Column
    private String nombre_es;

    @NotBlank(message = "El campo 'nombre_en' no puede estar en blanco.")
    @Size(max = 255, message = "El campo 'nombre_en' no puede tener más de 255 caracteres.")
    @Column
    private String nombre_en;

    @NotBlank(message = "El campo 'descripcion_es' no puede estar en blanco.")
    @Size(max = 1000, message = "El campo 'descripcion_es' no puede tener más de 1000 caracteres.")
    @Column
    private String descripcion_es;

    @NotBlank(message = "El campo 'descripcion_en' no puede estar en blanco.")
    @Size(max = 1000, message = "El campo 'descripcion_en' no puede tener más de 1000 caracteres.")
    @Column
    private String descripcion_en;

    @NotBlank(message = "El campo 'link' no puede estar en blanco.")
    @URL(message = "El campo 'link' debe ser una URL válida.")
    @Size(max = 255, message = "El campo 'link' no puede tener más de 255 caracteres.")
    @Column
    private String link;

    @URL(message = "El campo 'link_foto' debe ser una URL válida.")
    @Size(max = 255, message = "El campo 'link_foto' no puede tener más de 255 caracteres.")
    @Column
    private String link_foto;
}
