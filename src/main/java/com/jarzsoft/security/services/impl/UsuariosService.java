package com.jarzsoft.security.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.entities.Usuarios;
import com.jarzsoft.mapper.IProfileMapper;
import com.jarzsoft.repository.UsuariosRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IUsuariosService;

@Service
public class UsuariosService implements IUsuariosService {

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final UsuariosRepository usuario;

	@Autowired
	public UsuariosService(W_Bas_UsuarioRepository usuarioRepository, IProfileMapper mapper,
			UsuariosRepository usuario) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuario = usuario;

	}

	@Override
	public String getInternalUser(String id) {

		List<Object[]> externalUser = usuarioRepository.findByUsuario(id);

		Usuarios internalUser = usuario.loadUserByCodter(externalUser.get(0)[2] + "");

		return internalUser.getUsuario();
	}

}
