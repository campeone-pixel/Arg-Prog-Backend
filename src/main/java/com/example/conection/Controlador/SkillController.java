package com.example.conection.Controlador;
import com.example.conection.Modelo.Skill;
import com.example.conection.Servicios.SkillServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Skill> obtenerListaSkill() {
        return skillServicio.traer();
    }

    @PostMapping("/crear")
    public void crearSkill(@RequestBody Skill skill) {
        skillServicio.crear(skill);
    }

    @PutMapping("/editar")
    public void editarSkill(@RequestBody Skill skill) {
        skillServicio.editar(skill);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarSkill(@PathVariable long id) {
        skillServicio.eliminar(id);
    }
}