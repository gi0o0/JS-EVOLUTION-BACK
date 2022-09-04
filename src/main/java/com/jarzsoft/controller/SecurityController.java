package com.jarzsoft.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_SECURITY)
public class SecurityController {

	@Value("${auth.cookie.max}")
	private int authCookieMax;

	@Value("${auth.cookie.secure}")
	private boolean authCookieSecure;

	@Autowired
	public SecurityController() {
		super();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/signalrefresh")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> signOut(HttpServletRequest request, HttpServletResponse servletResponse) {

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().contentEquals("auth_by_cookie")) {
				cookie.setHttpOnly(true);
				cookie.setSecure(authCookieSecure);
				cookie.setMaxAge(authCookieMax);
				cookie.setPath("/");
				servletResponse.addCookie(cookie);
				break;
			}
		}

		return new ResponseEntity(null, HttpStatus.ACCEPTED);
	}

}
