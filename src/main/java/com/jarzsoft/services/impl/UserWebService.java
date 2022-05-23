package com.jarzsoft.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOW_Bas_Usuario;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IW_Bas_UsuarioMapper;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IUserWebService;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.service.IUserService;

@Service
public class UserWebService implements IUserWebService {

	private final W_Bas_UsuarioRepository dao;

	private final IW_Bas_UsuarioMapper mapper;

	private final IUserService usuarioService;

	public UserWebService(W_Bas_UsuarioRepository dao, IW_Bas_UsuarioMapper mapper, IUserService usuarioService) {
		super();
		this.dao = dao;
		this.mapper = mapper;
		this.usuarioService = usuarioService;

	}

	@Override
	public DTOW_Bas_Usuario create(DTOW_Bas_Usuario t) {

		t.setUsuCrea(usuarioService.getInternalUser(t.getUsuCrea()));
		t.setFecCrea(new Date());
		t.setFecUltMod(new Date());
		t.setUsuUltMod(t.getUsuCrea());
		W_Bas_Usuario usuario = mapper.mapperDtoToDao(t); 

		return mapper.mapperDaoToDto(dao.save(usuario));

	}

	@Override
	public DTOW_Bas_Usuario update(DTOW_Bas_Usuario t) {

		Optional<W_Bas_Usuario> old = dao.findByUserWeb(t.getUsuario());

		old.get().setEstado(t.getEstado());
		old.get().setCodPerfil(t.getCodPerfil());
		old.get().setFecUltMod(new Date());
		old.get().setUsuUltMod(usuarioService.getInternalUser(t.getUsuCrea()));

		return mapper.mapperDaoToDto(dao.save(old.get()));
	}

	@Override
	public ResponseEntity<Object> delete(int id) {

		return null;
	}
	
	@Override
	public ResponseEntity<Object> delete(String usuario) {
		dao.delete(mapper.mapperDtoToDao(usuario));
		return ResponseEntity.ok(Constantes.MESSAGE_REGISTER_DELETE);
	}

	@Override
	public List<DTOW_Bas_Usuario> listAll() {
		// return mapper.mapperList(dao.findAll());
		return mapper.mapperList(dao.findUserComplete());
	}
	
	@Override
	public List<DTOW_Bas_Usuario> listAllObj() {
		// return mapper.mapperList(dao.findAll());
		return mapper.mapperListObj(dao.findUserCompleteObj());
	}


	@Override
	public DTOW_Bas_Usuario listById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
