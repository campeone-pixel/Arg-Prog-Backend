package com.example.conection.Controlador;
import com.example.conection.Modelo.Experiencia;
import com.example.conection.Servicios.ExperienciaServicio;


import com.example.conection.Modelo.validators.ValidationService;

import com.example.conection.exceptions.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/experiencia")
@RequiredArgsConstructor
public class ExperienciaController {

    private final ExperienciaServicio experienciaService;
    private final ValidationService<Experiencia> validator;




    @GetMapping("/todo")
    public List<Experiencia> obtenerExperiencia() {


        return experienciaService.traer();
    }
    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<String> crearExperiencia(@RequestBody Experiencia experiencia) {
        var violations = validator.validate(experiencia);

        if (!violations.isEmpty()) {
            String errorMessage = String.join("|", violations);
            throw new ValidationException(errorMessage);
        }

        experienciaService.crear(experiencia);
        return ResponseEntity.ok("Experiencia creada exitosamente");
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