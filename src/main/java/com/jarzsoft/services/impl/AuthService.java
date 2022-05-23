package com.jarzsoft.services.impl;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.UserDto;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.exception.ForbiddenException;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.exception.UnauthorizedException;
import com.jarzsoft.model.ChildrenDTO;
import com.jarzsoft.model.FuncionalidadSeccionDTO;
import com.jarzsoft.payload.request.LoginRequest;
import com.jarzsoft.payload.request.SignupRequest;
import com.jarzsoft.payload.request.SignupTokenRequest;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.repository.TercerosRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.repository.W_Men_OpcionRepository;
import com.jarzsoft.service.IAuthService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.Ldap;
import com.jarzsoft.util.SendEmail;

@Service
public class AuthService implements IAuthService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

	private final Comunes comunes;

	private final SendEmail sendEmail;

	private final ParametroRepository parametroRepository;

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final TercerosRepository terceros;

	private final W_Men_OpcionRepository opcionRepository;

	private final Ldap ldap;

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;

	@Autowired
	public AuthService(W_Bas_UsuarioRepository usuarioRepository, W_Men_OpcionRepository opcionRepository,
			Comunes comunes, SendEmail sendEmail, ParametroRepository parametroRepository, TercerosRepository terceros,
			Ldap ldap) {
		super();
		this.usuarioRepository = usuarioRepository;

		this.opcionRepository = opcionRepository;

		this.comunes = comunes;

		this.sendEmail = sendEmail;

		this.parametroRepository = parametroRepository;

		this.terceros = terceros;

		this.ldap = ldap;

	}

	@Override
	public ResponseEntity<Object> signUp(SignupRequest signUpRequest) {

		LOGGER.info("signUp:" + signUpRequest.getUsuario());
		String numId = signUpRequest.getUsuario();
		List<Object[]> usuario = usuarioRepository.findByUsuario(numId);

		if (usuario.size() == 0) {
			throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_FOUND);
		}
		String email = "";
		if (signUpRequest.getEmail() != null && !signUpRequest.getEmail().equals("")
				&& this.comunes.validarCorreo(signUpRequest.getEmail())) {
			email = signUpRequest.getEmail();
			this.terceros.modificarEmail((BigDecimal) usuario.get(0)[2], email);
		} else {
			email = (String) usuario.get(0)[1];
			if (email == null || email.equals("")) {
				throw new UnauthorizedException(Constantes.MESSAGE_EMAIL_NO_FOUND);
			}
		}

		String codeLink = comunes.generarHashPassword(numId);

		usuarioRepository.modificarClaveLink(numId, codeLink);
		sendEmail.Send(email, codeLink);

		return ResponseEntity.ok(Constantes.MESSAGE_OK_REGISTER_EMAIL + email);

	}

	@Override
	public UserDto authenticateUser(LoginRequest loginRequest) {

		String username = loginRequest.getUsuario();

		W_Bas_Usuario user = usuarioRepository.loadUserByUsername(username);

		if (user == null)
			throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_FOUND);

		String clave_umbral = user.getClave_umbral();

		if (Constantes.STATE_UMBRAL_4.equals(clave_umbral))
			throw new ForbiddenException(Constantes.MESSAGE_USER_BLOCKED);

		if (validateDatePassword(user.getDate_mod()))
			throw new UnauthorizedException(Constantes.MESSAGE_PASSWPRD_EXPIRED);

		String tipoAut = user.getTipoAut();

		if ("1".equals(tipoAut)) {

			String existLdap = ldap.validateLdap(username, loginRequest.getPassword());

			if (!existLdap.equals(""))
				throw new UnauthorizedException(Constantes.MESSAGE_USER_NO_FOUND);

		} else {

			List<Object[]> usuario = usuarioRepository.findByUsuarioAndPassword(username,
					comunes.generarHashPassword(loginRequest.getPassword()));

			if (usuario.size() == 0)
				incrementUmbralUser(clave_umbral, username);

		}

		usuarioRepository.modificarClaveumbral(Constantes.STATE_UMBRAL_0, username);

		return new UserDto(loginRequest.getUsuario(), user.getNom_usuario(), "", "", "",
				funcionalidadesByPerfil(user.getCodPerfil()));

	}

	private Boolean validateDatePassword(String date_mod) {

		if (date_mod == null)
			return false;

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date fechaInicial = dateFormat.parse(date_mod);
			int dias = (int) ((new Date().getTime() - fechaInicial.getTime()) / 86400000);

			int maxDias = Integer.parseInt(parametroRepository.findByParamIdAndParamtext("PASS", "MAX").getValue());

			if (dias >= maxDias)
				return true;
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}

		return false;
	}

	private void incrementUmbralUser(String clave_umbral, String username) {
		if (null == clave_umbral || "0".equals(clave_umbral)) {
			clave_umbral = Constantes.STATE_UMBRAL_1;
		} else {
			clave_umbral = (Integer.parseInt(clave_umbral) + 1) + "";
		}
		usuarioRepository.modificarClaveumbral(clave_umbral, username);
		throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_FOUND);
	}

	private List<FuncionalidadSeccionDTO> funcionalidadesByPerfil(int codPerfil) {
		List<Object[]> userFuncionalidades = opcionRepository.findByCodPerfil(codPerfil);

		List<FuncionalidadSeccionDTO> funcionalidad = new ArrayList<FuncionalidadSeccionDTO>();
		funcionalidad.add(new FuncionalidadSeccionDTO("", Constantes.HEADER_DEFAULT_NAME, Constantes.HEADER_DEFAULT_URL,
				Constantes.HEADER_DEFAULT_ICON));
		List<String> filter = new ArrayList<String>();

		for (Object[] obj : userFuncionalidades) {

			String id = obj[0] + "";
			if (!filter.contains(id)) {
				filter.add(id);
				funcionalidad.add(new FuncionalidadSeccionDTO(id + "", obj[1] + "", obj[2] + "", obj[3] + ""));
			}

		}

		for (FuncionalidadSeccionDTO fun : funcionalidad) {
			List<ChildrenDTO> children = new ArrayList<>();
			for (Object[] obj : userFuncionalidades) {

				if (fun.getId().equals(obj[0] + "")) {
					children.add(new ChildrenDTO(obj[4] + "", obj[5] + "", obj[6] + "", obj[3] + ""));
				}

			}
			fun.setChildren(children);
		}

		return funcionalidad;

	}

	@Override
	public ResponseEntity<Object> signUpBytoken(SignupTokenRequest signupTokenRequest) {
		LOGGER.info("signUpBytoken:" + signupTokenRequest.getToken());

		Object[] user = usuarioRepository.findByUsuarioAndClaveLink(signupTokenRequest.getToken());
		if (user.length == 0)
			throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_FOUND);

		W_Bas_Usuario userHis = usuarioRepository.findByUsuarioAndClaveHis(user[0] + "",
				comunes.generarHashPassword(signupTokenRequest.getPassword()));

		if (userHis != null)
			throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_PASSWORD_HIS);

		usuarioRepository.modificarClaveGlobal(user[0] + "",
				comunes.generarHashPassword(signupTokenRequest.getPassword()));

		return ResponseEntity.ok(Constantes.MESSAGE_OK_REGISTER_CLAVE);
	}

	public String createToken(UserDto user) {
		return user.getId() + "&" + calculateHmac(user.getId());
	}

	public UserDto findByToken(String userId, String hmac) {

		W_Bas_Usuario user = usuarioRepository.loadUserByUsername(userId);

		if (user == null)
			throw new RuntimeException("Invalid Cookie value");

		if (!hmac.equals(calculateHmac(userId)) || !userId.equals(user.getUsuario().trim())) {
			throw new RuntimeException("Invalid Cookie value");
		}

		return new UserDto(userId, "", "", "", "", null);
	}

	private String calculateHmac(String userId) {
		byte[] secretKeyBytes = Objects.requireNonNull(secretKey).getBytes(StandardCharsets.UTF_8);
		byte[] valueBytes = Objects.requireNonNull(userId).getBytes(StandardCharsets.UTF_8);

		try {
			Mac mac = Mac.getInstance("HmacSHA512");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "HmacSHA512");
			mac.init(secretKeySpec);
			byte[] hmacBytes = mac.doFinal(valueBytes);
			return Base64.getEncoder().encodeToString(hmacBytes);

		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			throw new RuntimeException(e);
		}
	}

}
