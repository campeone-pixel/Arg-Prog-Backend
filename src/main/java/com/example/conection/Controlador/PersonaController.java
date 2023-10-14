package com.example.conection.Controlador;
import com.example.conection.Modelo.Persona;
import com.example.conection.Servicios.PersonaServicio;
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
    public List<Persona> obtenerListaPersona() {
        return personaServicio.traer();
    }
    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public void crearPersona(@RequestBody Persona persona) {
        personaServicio.crear(persona);
    }
    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public void editarPersona(@RequestBody Persona persona) {
        personaServicio.editar(persona);
    }
    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(@PathVariable long id) {
        personaServicio.eliminar(id);
    }
}
