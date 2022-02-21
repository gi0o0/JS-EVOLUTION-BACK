package com.jarzsoft.security.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.entities.Usuarios;
import com.jarzsoft.mapper.IUserMapper;
import com.jarzsoft.repository.UsuariosRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IUserService;

@Service
public class UserService implements IUserService {

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final UsuariosRepository usuario;

	private final IUserMapper mapper;

	@Autowired
	public UserService(W_Bas_UsuarioRepository usuarioRepository, UsuariosRepository usuario, IUserMapper mapper) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuario = usuario;
		this.mapper = mapper;

	}

	@Override
	public String getInternalUser(String id) {

		List<Object[]> externalUser = usuarioRepository.findByUsuario(id);

		Usuarios internalUser = usuario.loadUserByCodter(externalUser.get(0)[2] + "");

		return internalUser.getUsuario();
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

}
