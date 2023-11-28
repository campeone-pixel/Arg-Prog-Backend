package com.example.conection.Controlador;
import com.example.conection.Modelo.Skill;
import com.example.conection.Servicios.SkillServicio;
import com.example.conection.authentication.services.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.authentication.dto.UserData;
import com.example.conection.exceptions.StatusCode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
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
    public Result obtenerListaSkill( WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            List<Skill> skillList = skillServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skillList);
        } catch (Exception e) {
            String path = "";
            RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
            if (attribs instanceof ServletRequestAttributes) {
                path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
            }
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            String exceptionName = e.getClass().getSimpleName();
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearSkill(@Valid @RequestBody Skill skill,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.crear(skill);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skill);
        } catch (Exception e) {
            String path = "";
            RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
            if (attribs instanceof ServletRequestAttributes) {
                path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
            }
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            String exceptionName = e.getClass().getSimpleName();
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);        }
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PutMapping("/editar")
    public Result editarSkill(@Valid @RequestBody Skill skill,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.editar(skill);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, skill);
        } catch (Exception e) {
            String path = "";
            RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
            if (attribs instanceof ServletRequestAttributes) {
                path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
            }
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            String exceptionName = e.getClass().getSimpleName();
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);        }
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping("/eliminar/{id}")
    public Result eliminarSkill(@PathVariable long id,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            skillServicio.eliminar(id);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, null);
        } catch (Exception e) {
            String path = "";
            RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
            if (attribs instanceof ServletRequestAttributes) {
                path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
            }
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            String exceptionName = e.getClass().getSimpleName();
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);
        }
    }
}