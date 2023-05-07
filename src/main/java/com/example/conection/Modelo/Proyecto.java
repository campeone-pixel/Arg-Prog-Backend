package com.example.conection.Modelo;

import jakarta.persistence.*;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String link;
}
