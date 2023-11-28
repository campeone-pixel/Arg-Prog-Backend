package com.example.conection.authentication.services;

import com.example.conection.authentication.modelo.token.TokenRepository;
import com.example.conection.authentication.modelo.user.User;
import com.example.conection.authentication.dto.UserData;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDataService {

    public final TokenRepository tokenRepository;

    public UserDataService(TokenRepository tokenRepository){
        this.tokenRepository = tokenRepository;
    }

    public UserData getUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();

            // Verifica que el principal sea un usuario antes de intentar acceder a su ID
            if (user != null) {
                List token = tokenRepository.findAllValidTokenByUser(user.getId());
                return new UserData(user, token);
            }
        }

        return null;
    }
}
