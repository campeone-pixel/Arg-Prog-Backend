package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String escuela;
    @Column
    private String titulo_es;
    @Column
    private String titulo_en;
    @Column
    private String imagen;
    @Column
    private String carrera_es;
    @Column
    private String carrera_en;
    @Column
    private String inicio;
    @Column
    private String fin;
}
