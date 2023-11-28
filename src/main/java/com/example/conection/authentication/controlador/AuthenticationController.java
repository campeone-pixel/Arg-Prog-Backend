package com.example.conection.authentication.controlador;

import com.example.conection.Modelo.Educacion;
import com.example.conection.authentication.services.AuthenticationService;
import com.example.conection.authentication.dto.AuthenticationRequest;
import com.example.conection.authentication.dto.AuthenticationResponse;
import com.example.conection.authentication.dto.RegisterRequest;
import com.example.conection.dto.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  public Result register(
      @RequestBody RegisterRequest request
  ) {
    Object token = service.register(request);
    return new Result(true, 200, "Success", LocalDateTime.now(),  token);

  }
  @PostMapping("/authenticate")
  public Result authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    Object token = service.authenticate(request);
    return new Result(true, 200, "Success", LocalDateTime.now(),  token);

  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
