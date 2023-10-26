package com.example.conection.Controlador;
import com.example.conection.Modelo.Persona;
import com.example.conection.Servicios.PersonaServicio;
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
@RequestMapping("/persona")


public class PersonaController {

    private final PersonaServicio personaServicio;
    private final UserDataService userDataService;

    @Autowired
    public PersonaController(PersonaServicio personaServicio, UserDataService userDataService) {
        this.personaServicio = personaServicio;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerListaPersona() {
        try {
            UserData userData = userDataService.getUserData();
            List<Persona> personaList = personaServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, personaList);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage() );
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearPersona(@Valid @RequestBody Persona persona) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.crear(persona);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, persona);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarPersona(@Valid @RequestBody Persona persona) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.editar(persona);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, persona);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage() );
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarPersona(@PathVariable long id) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }
}
