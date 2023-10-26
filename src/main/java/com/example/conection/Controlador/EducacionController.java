package com.example.conection.Controlador;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Servicios.EducacionServicio;
import com.example.conection.dto.Result;
import jakarta.validation.Valid;
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
    public Result obtenerEducacion() {
        try {
            List<Educacion> educacionList = educacionServicio.traer();
            return new Result(true, 200, "Success", educacionList);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearEducacion(@Valid @RequestBody Educacion educacion) {
        try {
            educacionServicio.crear(educacion);
            return new Result(true, 200, "Success", educacion);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public Result editarEducacion(@Valid @RequestBody Educacion educacion) {
        try {
            educacionServicio.editar(educacion);
            return new Result(true, 200, "Success", educacion);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Result eliminarEducacion(@PathVariable long id) {
        try {
            educacionServicio.eliminar(id);
            return new Result(true, 200, "Success", null);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }
}
