package com.jarzsoft.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.entities.Usuarios;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IUserMapper;
import com.jarzsoft.repository.UsuariosRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Comunes;

@Service
public class UserService implements IUserService {

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final UsuariosRepository usuario;

	private final IUserMapper mapper;

	private final ITercerosService tercerosService;

	@Autowired
	public UserService(W_Bas_UsuarioRepository usuarioRepository, UsuariosRepository usuario, IUserMapper mapper,
			ITercerosService tercerosService) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuario = usuario;
		this.mapper = mapper;
		this.tercerosService = tercerosService;
	}

	@Override
	public String getInternalUser(String id) {
		List<Object[]> externalUser = usuarioRepository.findByUsuario(id);
		Usuarios internalUser = usuario.loadUserByCodter(externalUser.get(0)[2] + "");
		if (null != internalUser)
			return internalUser.getUsuario();

		return "";

	}

	@Override
	public List<DTOUser> listAll() {
		return mapper.mapperList(usuarioRepository.findAll());
	}

	@Override
	public DTOUser updateProfile(DTOUser user) {
		usuarioRepository.modificarCodperfil(user.getId(), user.getIdProfile(), user.getUsuCrea());
		return user;
	}

	@Override
	public DTOTerceros findByNiter(String nitTer) {
		return tercerosService.findByNiter(nitTer);
	}

	@Override
	public DTOUser create(DTOUser user) {

		Optional<W_Bas_Usuario> oldUser = usuarioRepository.findById(user.getId());

		if (oldUser.isPresent()) {
			W_Bas_Usuario u = oldUser.get();
			u.setCodPerfil(Comunes.stringToInteger(user.getIdProfile()));
			u.setEstado(user.getEstado());
			usuarioRepository.save(u);
		} else {
			usuarioRepository.save(mapper.mapperDtoToDao(user));
		}

		return user;
	}

	@Override
	public List<DTOUser> sync() {
		List<Object[]> usuarios = usuarioRepository.findUsersFodataso();
		List<DTOUser> res = new ArrayList<>();

		for (Object[] o : usuarios) {
			DTOUser user = new DTOUser();
			user.setId((String) o[0]);
			user.setIdProfile("3");
			user.setName(Comunes.stringClean((String) o[2]) + " " + Comunes.stringClean((String) o[3]) + " "
					+ Comunes.stringClean((String) o[4]));
			user.setEstado("0");
			BigDecimal cod = (BigDecimal) o[1];
			user.setCodTer(cod.intValue());
			create(user);
			res.add(user);

		}

		return res;
	}

}
