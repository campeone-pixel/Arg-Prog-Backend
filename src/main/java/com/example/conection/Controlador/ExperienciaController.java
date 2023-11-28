package com.example.conection.Controlador;
import com.example.conection.Modelo.Experiencia;
import com.example.conection.Servicios.ExperienciaServicio;


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
@RequestMapping("/experiencia")

public class ExperienciaController {

    private final ExperienciaServicio experienciaService;
    private final UserDataService userDataService;

    @Autowired
    public ExperienciaController(ExperienciaServicio experienciaService, UserDataService userDataService) {
        this.experienciaService = experienciaService;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerExperiencia( WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            List<Experiencia> experienciaList = experienciaService.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experienciaList);
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

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearExperiencia(@Valid @RequestBody Experiencia experiencia,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.crear(experiencia);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experiencia);
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

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('admin:update')")
    public Result editarExperiencia(@Valid @RequestBody Experiencia experiencia,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.editar(experiencia);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, experiencia);
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

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public Result eliminarExperiencia(@PathVariable long id,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            experienciaService.eliminar(id);
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