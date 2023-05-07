package com.example.conection.Modelo;

import jakarta.persistence.*;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String Puesto;
    @Column
    private String lugar;
    @Column
    private String desde;
    @Column
    private String hasta;
    @Column
    private String empresa;
}
