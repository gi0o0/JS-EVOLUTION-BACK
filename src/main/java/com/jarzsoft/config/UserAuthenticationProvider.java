package com.jarzsoft.config;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.UserDto;
import com.jarzsoft.entities.Folog;
import com.jarzsoft.payload.request.LoginRequest;
import com.jarzsoft.service.IAuthService;
import com.jarzsoft.service.IFologService;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	private final IAuthService authService;

	private final IFologService fologService;

	@Value("${spring.datasource.username}")
	private String userdb;

	public UserAuthenticationProvider(IAuthService authService, IFologService fologService) {
		this.authService = authService;
		this.fologService = fologService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UserDto userDto = null;
		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			userDto = authService.authenticateUser(new LoginRequest((String) authentication.getPrincipal(),
					String.copyValueOf((char[]) authentication.getCredentials())));
		} else if (authentication instanceof PreAuthenticatedAuthenticationToken) {
			HttpServletRequest request = (HttpServletRequest) authentication.getCredentials();

			String cookie = (String) authentication.getPrincipal();
			String[] parts = cookie.split("&");
			String userId = parts[0];
			String hmac = parts[1];
			userDto = authService.findByToken(userId, hmac);

			writeTrace(userId, request);

		}

		if (userDto == null) {
			return null;
		}

		return new UsernamePasswordAuthenticationToken(userDto, null, Collections.emptyList());
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}

	private void writeTrace(String userId, HttpServletRequest request) {
		String method = request.getMethod();
		String url = request.getServletPath();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		fologService.create(
				new Folog(userdb, now, now, format.format(now), format.format(now), userId, method + "-" + url));

	}
}
