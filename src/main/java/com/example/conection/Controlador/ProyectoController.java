package com.example.conection.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Proyecto> obtenerListaProyecto() {
        return proyectoServicio.traer();
    }

    @PostMapping("/crear")
    public void crearProyecto(@RequestBody Proyecto proyecto) {
        proyectoServicio.crear(proyecto);
    }

    @PutMapping("/editar")
    public void editarProyecto(@RequestBody Proyecto proyecto) {
        proyectoServicio.editar(proyecto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProyecto(@PathVariable long id) {
        proyectoServicio.eliminar(id);
    }
}