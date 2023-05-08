package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;

@Entity@Getter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombre;
    @Column
    private String porcentaje;
}
