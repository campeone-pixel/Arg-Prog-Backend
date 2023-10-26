package com.example.conection.Controlador;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Servicios.EducacionServicio;
import com.example.conection.Servicios.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.dto.UserData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/educacion")

public class EducacionController {

    private final EducacionServicio educacionServicio;
    private final UserDataService userDataService;

    @Autowired
    public EducacionController(EducacionServicio educacionServicio, UserDataService userDataService) {
        this.educacionServicio = educacionServicio;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerEducacion() {
        try {
            UserData userData = userDataService.getUserData();
            List<Educacion> educacionList = educacionServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacionList);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearEducacion(@Valid @RequestBody Educacion educacion) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.crear(educacion);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacion);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public Result editarEducacion(@Valid @RequestBody Educacion educacion) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.editar(educacion);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacion);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Result eliminarEducacion(@PathVariable long id) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }
}
