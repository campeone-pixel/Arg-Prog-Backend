package com.example.conection.Controlador;
import com.example.conection.Modelo.Skill;
import com.example.conection.Servicios.SkillServicio;
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
@RequestMapping("/skill")


public class SkillController {


    private final SkillServicio skillServicio;
    private final UserDataService userDataService;

    @Autowired
    public SkillController(SkillServicio skillServicio, UserDataService userDataService) {
        this.skillServicio = skillServicio;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerListaSkill() {
        try {
            UserData userData = userDataService.getUserData();
            List<Skill> skillList = skillServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skillList);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearSkill(@Valid @RequestBody Skill skill) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.crear(skill);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skill);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarSkill(@Valid @RequestBody Skill skill) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.editar(skill);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skill);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarSkill(@PathVariable long id) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            return new Result<>(false, 500, "Error", LocalDateTime.now(), null,  e.getMessage());
        }
    }
}