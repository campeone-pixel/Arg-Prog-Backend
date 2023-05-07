package com.example.conection.Modelo;

import jakarta.persistence.*;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;
    
}
