package com.config;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenValidator(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Skip token validation for these paths
        String path = request.getRequestURI();
        if ("/api/users/register".equals(path) || "/api/users/login".equals(path)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Your existing JWT validation logic here

        filterChain.doFilter(request, response);


		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
	}
}
