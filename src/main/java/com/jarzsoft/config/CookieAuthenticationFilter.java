package com.jarzsoft.config;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class CookieAuthenticationFilter extends OncePerRequestFilter {

	public static final String COOKIE_NAME = "auth_by_cookie";

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		Optional<Cookie> cookieAuth = Stream
				.of(Optional.ofNullable(httpServletRequest.getCookies()).orElse(new Cookie[0]))
				.filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst();

		if (cookieAuth.isPresent()) {
			SecurityContextHolder.getContext().setAuthentication(
					new PreAuthenticatedAuthenticationToken(cookieAuth.get().getValue(), httpServletRequest));
			String cookie = (String) cookieAuth.get().getValue();
			String[] parts = cookie.split("&");
			httpServletRequest.setAttribute("user", parts[0]);
		} else {

			String path = httpServletRequest.getServletPath();
			if ("/auth/token/check".equals(path) || "/auth/signin".equals(path) || "/auth/signup".equals(path)
					|| "/auth/signup/token".equals(path)) {
				httpServletRequest.setAttribute("user", "default");
			}
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
