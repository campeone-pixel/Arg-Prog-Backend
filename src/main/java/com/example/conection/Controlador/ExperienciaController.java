package com.example.conection.Controlador;
import com.example.conection.Modelo.Experiencia;
import com.example.conection.Servicios.ExperienciaServicio;


import com.example.conection.Servicios.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.dto.UserData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/experiencia")

public class ExperienciaController {

    private final ExperienciaServicio experienciaService;
    private final UserDataService userDataService;

    @Autowired
    public ExperienciaController(ExperienciaServicio experienciaService, UserDataService userDataService) {
        this.experienciaService = experienciaService;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerExperiencia() {
        try {
            UserData userData = userDataService.getUserData();
            List<Experiencia> experienciaList = experienciaService.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experienciaList);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearExperiencia(@Valid @RequestBody Experiencia experiencia) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.crear(experiencia);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experiencia);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public Result editarExperiencia(@Valid @RequestBody Experiencia experiencia) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.editar(experiencia);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experiencia);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Result eliminarExperiencia(@PathVariable long id) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }
}