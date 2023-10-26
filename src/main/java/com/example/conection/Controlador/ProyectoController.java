package com.example.conection.Controlador;

import com.example.conection.Modelo.user.User;
import com.example.conection.Servicios.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.dto.UserData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


import com.example.conection.Modelo.Proyecto;
import com.example.conection.Servicios.ProyectoServicio;



@RestController
@RequestMapping("/proyecto")


public class ProyectoController {

    private final ProyectoServicio proyectoServicio;
    private final UserDataService userDataService;

    @Autowired
    public ProyectoController(ProyectoServicio proyectoServicio,UserDataService userDataService) {
        this.proyectoServicio = proyectoServicio;this.userDataService = userDataService;
    }


    @GetMapping("/todo")
    public Result obtenerListaProyecto() {
        try {
            UserData userData = userDataService.getUserData();
            List<Proyecto> proyectoList = proyectoServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyectoList);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearProyecto(@Valid @RequestBody Proyecto proyecto) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.crear(proyecto);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyecto);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null, e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarProyecto(@Valid @RequestBody Proyecto proyecto) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.editar(proyecto);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyecto);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarProyecto(@PathVariable long id) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }
}