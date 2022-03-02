package com.jarzsoft.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jarzsoft.dto.CredentialsDto;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {

		if ("/auth/signin".equals(httpServletRequest.getServletPath())
				&& HttpMethod.POST.matches(httpServletRequest.getMethod())) {
			CredentialsDto credentialsDto = MAPPER.readValue(httpServletRequest.getInputStream(), CredentialsDto.class);

			SecurityContextHolder.getContext().setAuthentication(
					new UsernamePasswordAuthenticationToken(credentialsDto.getLogin(), credentialsDto.getPassword()));
		}

		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
