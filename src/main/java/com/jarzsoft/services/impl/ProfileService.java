package com.jarzsoft.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.entities.W_Bas_T_Perfil;
import com.jarzsoft.mapper.IProfileMapper;
import com.jarzsoft.repository.W_Bas_T_PerfilRepository;
import com.jarzsoft.service.IProfileService;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Constantes;

@Service
public class ProfileService implements IProfileService {

	private final W_Bas_T_PerfilRepository dao;

	private final IProfileMapper mapper;

	private final IUserService usuarioService;

	@Autowired
	public ProfileService(W_Bas_T_PerfilRepository perfilRepository, IProfileMapper mapper,
			IUserService usuarioService) {
		super();
		this.dao = perfilRepository;
		this.mapper = mapper;
		this.usuarioService = usuarioService;

	}

	@Override
	public DTOProfile create(DTOProfile t) {

		t.setUsuCrea(usuarioService.getInternalUser(t.getUsuCrea()));
		t.setId(dao.getKey() + "");
		t.setFecCrea(new Date());
		return mapper.mapperDaoToDto(dao.save(mapper.mapperDtoToDao(t)));

	}

	@Override
	public DTOProfile update(DTOProfile t) {
		Optional<W_Bas_T_Perfil> old = dao.findById(Long.parseLong(t.getId()));

		old.get().setNomPerfil(t.getName());
		old.get().setFecUltMod(new Date());
		old.get().setUsuUltMod(usuarioService.getInternalUser(t.getUsuCrea()));

		return mapper.mapperDaoToDto(dao.save(old.get()));
	}

	@Override
	public ResponseEntity<Object> delete(int id) {
		dao.delete(dao.findById(new Long(id)).get());
		return ResponseEntity.ok(Constantes.MESSAGE_REGISTER_DELETE);
	}

	@Override
	public DTOProfile listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DTOProfile> listAll() {
		return mapper.mapperList(dao.findAll());
	}

}
