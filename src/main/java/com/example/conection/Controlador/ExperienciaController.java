package com.example.conection.Controlador;
import com.example.conection.Modelo.Experiencia;
import com.example.conection.Servicios.ExperienciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/experiencia")

public class ExperienciaController {

    private final ExperienciaServicio experienciaService;

    @Autowired
    public ExperienciaController(ExperienciaServicio experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping("/todo")
    public List<Experiencia> obtenerExperiencia() {
        return experienciaService.traer();
    }
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public void crearExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.crear(experiencia);
    }
    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public void editarExperiencia(@RequestBody Experiencia experiencia) {
        experienciaService.editar(experiencia);
    }
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public void eliminarExperiencia(@PathVariable long id) {
        experienciaService.eliminar(id);
    }
}