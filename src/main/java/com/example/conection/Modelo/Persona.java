package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombres;
    @Column
    private String apellido;
    @Column
    private String nacionalidad_es;
    @Column
    private String nacionalidad_en;
    @Column
    private String email;
    @Column
    private String sobre_mi_es;
    @Column
    private String sobre_mi_en;
    @Column
    private String ocupacion_es;
    @Column
    private String ocupacion_en;
    @Column
    private String image_background_header;
    @Column
    private String image_perfil;
    @Column
    private String image_sobre_mi;
}