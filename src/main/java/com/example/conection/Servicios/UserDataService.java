package com.example.conection.Servicios;

import com.example.conection.Modelo.token.Token;
import com.example.conection.Modelo.user.User;
import com.example.conection.dto.UserData;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserDataService {


    public UserData getUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            String token = user.getTokens().toString();
            return new UserData(user, token);
        }

        return null;
    }
}
