package com.example.conection.Controlador;
import com.example.conection.Modelo.Persona;
import com.example.conection.Servicios.PersonaServicio;
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
    public Result obtenerListaPersona( WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            List<Persona> personaList = personaServicio.traer();
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, personaList);
        } catch (Exception e) {
            String path = "";
            RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
            if (attribs instanceof ServletRequestAttributes) {
                path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
            }
            String stackTrace = e.getStackTrace().toString();
            String exceptionName = e.getClass().getSimpleName();
            return new Result(false, StatusCode.UNAUTHORIZED,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  e.getMessage(),exceptionName);        }
    }

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping("/crear")
    public Result crearPersona(@Valid @RequestBody Persona persona,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.crear(persona);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, persona);
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
    public Result editarPersona(@Valid @RequestBody Persona persona,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.editar(persona);
            return new Result<>(true, 200, "Success", LocalDateTime.now(), userData, persona);
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
    public Result eliminarPersona(@PathVariable long id,WebRequest request) {
        try {
            UserData userData = userDataService.getUserData();
            personaServicio.eliminar(id);
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
