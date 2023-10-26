package com.example.conection.Controlador;
import com.example.conection.Modelo.Skill;
import com.example.conection.Servicios.SkillServicio;
import com.example.conection.dto.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



@RestController
@RequestMapping("/skill")


public class SkillController {

    private final SkillServicio skillServicio;

    @Autowired
    public SkillController(SkillServicio skillServicio) {
        this.skillServicio = skillServicio;
    }


    @GetMapping("/todo")
    public Result obtenerListaSkill() {
        try {
            List<Skill> skillList = skillServicio.traer();
            return new Result(true, 200, "Success", skillList);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearSkill(@Valid @RequestBody Skill skill) {
        try {
            skillServicio.crear(skill);
            return new Result(true, 200, "Success", skill);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarSkill(@Valid @RequestBody Skill skill) {
        try {
            skillServicio.editar(skill);
            return new Result(true, 200, "Success", skill);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarSkill(@PathVariable long id) {
        try {
            skillServicio.eliminar(id);
            return new Result(true, 200, "Success", null);
        } catch (Exception e) {
            return new Result(false, 500, "Error", e.getMessage());
        }
    }
}