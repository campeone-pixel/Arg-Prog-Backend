package com.example.conection.Modelo;

import jakarta.persistence.*;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String escuela;
    @Column
    private String titulo;
    @Column
    private String imagen;
    @Column
    private String carrera;
    @Column
    private String inicio;
    @Column
    private String fin;
}
