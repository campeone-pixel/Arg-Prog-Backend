package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;

@Entity@Getter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String puesto;
    @Column
    private String lugar;
    @Column
    private String desde;
    @Column
    private String hasta;
    @Column
    private String empresa;
    @Column
    private String descripcion;
}
