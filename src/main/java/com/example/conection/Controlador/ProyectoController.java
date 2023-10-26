package com.example.conection.Controlador;

import com.example.conection.dto.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import com.example.conection.Modelo.Proyecto;
import com.example.conection.Servicios.ProyectoServicio;



@RestController
@RequestMapping("/proyecto")


public class ProyectoController {

    private final ProyectoServicio proyectoServicio;

    @Autowired
    public ProyectoController(ProyectoServicio proyectoServicio) {
        this.proyectoServicio = proyectoServicio;
    }

    @GetMapping("/todo")
    public Result obtenerListaProyecto() {
        try {
            List<Proyecto> proyectoList = proyectoServicio.traer();
            return new Result(true, 200, "Success", proyectoList);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearProyecto(@Valid @RequestBody Proyecto proyecto) {
        try {
            proyectoServicio.crear(proyecto);
            return new Result(true, 200, "Success", proyecto);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarProyecto(@Valid @RequestBody Proyecto proyecto) {
        try {
            proyectoServicio.editar(proyecto);
            return new Result(true, 200, "Success", proyecto);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarProyecto(@PathVariable long id) {
        try {
            proyectoServicio.eliminar(id);
            return new Result(true, 200, "Success", null);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }
}