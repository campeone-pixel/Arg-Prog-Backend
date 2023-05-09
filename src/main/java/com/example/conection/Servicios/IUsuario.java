package com.example.conection.Servicios;

import com.example.conection.Modelo.Usuario;

public interface IUsuario {
    void crear(Usuario usuario);
    boolean iniciarSesion(Usuario usuario);
}
