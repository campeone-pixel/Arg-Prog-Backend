package com.example.conection.Servicios;

import com.example.conection.Modelo.Usuario;
import com.example.conection.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuario{
    @Autowired
    private UsuarioRepositorio repo;
    @Override
    public void crear(Usuario usuario) {
        repo.save(usuario);
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        boolean b = false;
        for (Usuario u: repo.findAll()) {
            if (usuario.getEmail().equals(u.getEmail()) && usuario.getContraseña().equals(u.getContraseña())){
                b = true;
                break;
            }
        }
        return b;
    }
}
