package com.example.conection.Controlador;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Servicios.EducacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/educacion")

public class EducacionController {

    private final EducacionServicio educacionServicio;

    @Autowired
    public EducacionController(EducacionServicio educacionServicio) {
        this.educacionServicio = educacionServicio;
    }

    @GetMapping("/todo")
    public List<Educacion> obtenerEducacion() {
        return educacionServicio.traer();
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public void crearEducacion(@RequestBody Educacion educacion) {
        educacionServicio.crear(educacion);
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public void editarEducacion(@RequestBody Educacion educacion) {
        educacionServicio.editar(educacion);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void eliminarEducacion(@PathVariable long id) {
        educacionServicio.eliminar(id);
    }
}
