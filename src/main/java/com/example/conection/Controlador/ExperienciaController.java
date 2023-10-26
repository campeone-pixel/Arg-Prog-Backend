package com.example.conection.Controlador;
import com.example.conection.Modelo.Experiencia;
import com.example.conection.Servicios.ExperienciaServicio;


import com.example.conection.dto.Result;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/experiencia")

public class ExperienciaController {

    private final ExperienciaServicio experienciaService;


    public ExperienciaController(ExperienciaServicio experienciaService) {
        this.experienciaService = experienciaService;

    }



    @GetMapping("/todo")
    public Result obtenerExperiencia() {
        try {
            List<Experiencia> experienciaList = experienciaService.traer();
            return new Result(true, 200, "Success", experienciaList);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearExperiencia(@Valid @RequestBody Experiencia experiencia) {
        try {
            experienciaService.crear(experiencia);
            return new Result(true, 200, "Success", experiencia);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public Result editarExperiencia(@Valid @RequestBody Experiencia experiencia) {
        try {
            experienciaService.editar(experiencia);
            return new Result(true, 200, "Success", experiencia);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Result eliminarExperiencia(@PathVariable long id) {
        try {
            experienciaService.eliminar(id);
            return new Result(true, 200, "Success", null);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }
}