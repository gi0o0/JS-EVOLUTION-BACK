package com.jarzsoft.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.config.CookieAuthenticationFilter;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.UserDto;
import com.jarzsoft.payload.request.SignupRequest;
import com.jarzsoft.payload.request.SignupTokenRequest;
import com.jarzsoft.service.IAuthService;
import com.jarzsoft.service.IWFPqrService;
import com.jarzsoft.service.IWFService;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumWF;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_AUTH)
public class AuthController {

	private final IAuthService authService;

	@Value("${auth.cookie.max}")
	private int authCookieMax;

	@Value("${auth.cookie.secure}")
	private boolean authCookieSecure;

	private final IWFService service;

	private final IWFPqrService pqrService;

	@Autowired
	public AuthController(IAuthService authService, IWFService service, IWFPqrService pqrService) {
		super();
		this.authService = authService;
		this.service = service;
		this.pqrService = pqrService;
	}

	@PostMapping("/signin")
	public ResponseEntity<UserDto> signIn(@AuthenticationPrincipal UserDto user, HttpServletResponse servletResponse) {
		Cookie authCookie = new Cookie(CookieAuthenticationFilter.COOKIE_NAME, authService.createToken(user));
		authCookie.setHttpOnly(true);
		authCookie.setSecure(authCookieSecure);
		authCookie.setMaxAge(authCookieMax);
		authCookie.setPath("/");
		servletResponse.addCookie(authCookie);
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		return ResponseEntity.ok(authService.signUp(signUpRequest));
	}

	@PostMapping("/signup/token")
	public ResponseEntity<?> registerUserByToken(@RequestBody SignupTokenRequest signupTokenRequest) {
		return ResponseEntity.ok(authService.signUpBytoken(signupTokenRequest));
	}

	@PostMapping("/token/check")
	public DTOWF checkTokenSol(@RequestBody DTOWF o, @RequestAttribute(name = "user") String user) {
		return callCheckEmail(o, user);
	}

	@PostMapping("/signout")
	public ResponseEntity<?> signOut(HttpServletResponse servletResponse) {
		Cookie authCookie = new Cookie(CookieAuthenticationFilter.COOKIE_NAME, null);
		authCookie.setHttpOnly(true);
		authCookie.setSecure(authCookieSecure);
		authCookie.setMaxAge(0);
		authCookie.setPath("/");
		servletResponse.addCookie(authCookie);
		return ResponseEntity.ok(true);
	}

	private DTOWF callCheckEmail(DTOWF o, String user) {

		if (EnumWF.TIPO_WF.IDWF_4.getName().equals(o.getIdWf())) {
			return service.create(o, user);
		}

		DTOWFPqr pqr = new DTOWFPqr();
		pqr.setNextStep(o.getNextStep());
		pqr.setIdSubStep(o.getIdSubStep());
		pqr.setToken(o.getToken());
		pqrService.create(pqr, user);

		return o;
	}

}
