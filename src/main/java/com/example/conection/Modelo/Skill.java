package com.example.conection.Modelo;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombre;
    @Column
    private String porcentaje;
}
