package com.example.conection.authentication.filter;


import com.example.conection.authentication.modelo.token.TokenRepository;
import com.example.conection.authentication.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            if (request.getServletPath().contains("/auth") || request.getServletPath().contains("/todo" ) || request.getServletPath().contains("/swagger-ui" ) || request.getServletPath().contains("/v3/api-docs") ) {
                filterChain.doFilter(request, response);
                return;
            }

            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userEmail;

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new AuthenticationCredentialsNotFoundException("No se proporcionó un token válido.");
            }

            jwt = authHeader.substring(7);
            userEmail = jwtService.extractUsername(jwt);

            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
                var isTokenValid = tokenRepository.findByToken(jwt)
                        .map(t -> !t.isExpired() && !t.isRevoked())
                        .orElse(false);

                if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContext sc = SecurityContextHolder.getContext();
                    sc.setAuthentication(authToken);

                }
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            // Capturar excepciones y dejar que los manejadores de excepciones personalizados se encarguen de ellas.
            resolver.resolveException(request, response, null, e);
        }
    }
}