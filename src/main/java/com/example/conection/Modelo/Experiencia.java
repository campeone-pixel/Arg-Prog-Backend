package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String puesto_es;
    @Column
    private String puesto_en;
    @Column
    private String lugar;
    @Column
    private String desde;
    @Column
    private String hasta;
    @Column
    private String empresa;
    @Column
    private String descripcion_es;
    @Column
    private String descripcion_en;
}
