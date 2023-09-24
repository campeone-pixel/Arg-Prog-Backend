package com.example.conection.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String nombre_es;
    @Column
    private String nombre_en;
    @Column
    private String descripcion_es;
    @Column
    private String descripcion_en;
    @Column
    private String link;
    @Column
    private String link_foto;
}
