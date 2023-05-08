package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;

@Entity@Getter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombres;
    @Column
    private String apellido;
    @Column
    private String nacionalidad;
    @Column
    private String email;
    @Column
    private String sobre_mi;
    @Column
    private String ocupacion;
    @Column
    private String image_background_header;
    @Column
    private String image_perfil;
}
