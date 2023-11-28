package com.example.conection.Controlador;

import com.example.conection.Modelo.Educacion;
import com.example.conection.Servicios.EducacionServicio;
import com.example.conection.authentication.services.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.authentication.dto.UserData;
import com.example.conection.exceptions.StatusCode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;



@RestController
@RequestMapping("/educacion")

public class EducacionController {

    private final EducacionServicio educacionServicio;
    private final UserDataService userDataService;

    @Autowired
    public EducacionController(EducacionServicio educacionServicio, UserDataService userDataService) {
        this.educacionServicio = educacionServicio;
        this.userDataService = userDataService;
    }

    @GetMapping("/todo")
    public Result obtenerEducacion(WebRequest request) {

        try {
            UserData userData = userDataService.getUserData();
            List<Educacion> educacionList = educacionServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacionList);
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

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('admin:create')")
    public Result crearEducacion(@Valid @RequestBody Educacion educacion,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.crear(educacion);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacion);
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
    public Result editarEducacion(@Valid @RequestBody Educacion educacion,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.editar(educacion);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, educacion);
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
    public Result eliminarEducacion(@PathVariable long id,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            educacionServicio.eliminar(id);
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
