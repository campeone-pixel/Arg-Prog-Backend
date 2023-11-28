package com.example.conection.Controlador;

import com.example.conection.authentication.services.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.authentication.dto.UserData;
import com.example.conection.exceptions.StatusCode;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;


import com.example.conection.Modelo.Proyecto;
import com.example.conection.Servicios.ProyectoServicio;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;


@RestController
@RequestMapping("/proyecto")


public class ProyectoController {

    private final ProyectoServicio proyectoServicio;
    private final UserDataService userDataService;

    @Autowired
    public ProyectoController(ProyectoServicio proyectoServicio,UserDataService userDataService) {
        this.proyectoServicio = proyectoServicio;this.userDataService = userDataService;
    }


    @GetMapping("/todo")
    public Result obtenerListaProyecto( WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            List<Proyecto> proyectoList = proyectoServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyectoList);
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
    public Result crearProyecto(@Valid @RequestBody Proyecto proyecto,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.crear(proyecto);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyecto);
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
    public Result editarProyecto(@Valid @RequestBody Proyecto proyecto,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.editar(proyecto);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, proyecto);
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
    public Result eliminarProyecto(@PathVariable long id,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            proyectoServicio.eliminar(id);
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
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);        }
    }
}