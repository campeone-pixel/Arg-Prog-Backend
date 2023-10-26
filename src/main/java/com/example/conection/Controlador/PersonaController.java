package com.example.conection.Controlador;
import com.example.conection.Modelo.Persona;
import com.example.conection.Servicios.PersonaServicio;
import com.example.conection.dto.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/persona")


public class PersonaController {

    private final PersonaServicio personaServicio;

    @Autowired
    public PersonaController(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/todo")
    public Result obtenerListaPersona() {
        try {
            List<Persona> personaList = personaServicio.traer();
            return new Result(true, 200, "Success", personaList);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearPersona(@Valid @RequestBody Persona persona) {
        try {
            personaServicio.crear(persona);
            return new Result(true, 200, "Success", persona);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarPersona(@Valid @RequestBody Persona persona) {
        try {
            personaServicio.editar(persona);
            return new Result(true, 200, "Success", persona);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarPersona(@PathVariable long id) {
        try {
            personaServicio.eliminar(id);
            return new Result(true, 200, "Success", null);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }
}
