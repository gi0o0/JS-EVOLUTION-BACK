package com.jarzsoft.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFosececo;
import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.entities.Fosececo;
import com.jarzsoft.entities.W_Bas_T_Perfil;
import com.jarzsoft.mapper.IFosececoMapper;
import com.jarzsoft.repository.FosececoRepository;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IFosececoService;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Constantes;

@Service
public class FosececoService implements IFosececoService {

	private final FosececoRepository dao;

	private final IFosececoMapper mapper;

	private final IUserService usuarioService;

	public FosececoService(FosececoRepository dao, IFosececoMapper mapper, IUserService usuarioService) {
		super();
		this.dao = dao;
		this.mapper = mapper;
		this.usuarioService = usuarioService;

	}

	@Override
	public DTOFosececo create(DTOFosececo t) {

		t.setUsuCrea(usuarioService.getInternalUser(t.getUsuCrea()));
		t.setFecCrea(new Date());
		t.setFecUltMod(new Date());
		t.setUsuUltMod(t.getUsuCrea());

		return mapper.mapperDaoToDto(dao.save(mapper.mapperDtoToDao(t)));

	}

	@Override
	public DTOFosececo update(DTOFosececo t) {

		Optional<Fosececo> old = dao.findById(t.getCodSec());
		 
	 	old.get().setnomSec(t.getNomSec());
		old.get().setFecUltMod(new Date());
		old.get().setUsuUltMod(usuarioService.getInternalUser(t.getUsuCrea()));

		return mapper.mapperDaoToDto(dao.save(old.get()));
	}

	@Override
	public List<DTOFosececo> listAll() {
		return mapper.mapperList(dao.findAll());
	}

	@Override
	public ResponseEntity<Object> delete(int id) {
		return null;
	}

	public DTOFosececo listById(int id) {
		return null;
	}

	@Override
	public ResponseEntity<Object> delete(String codSec) {
		dao.delete(mapper.mapperDtoToDao(codSec));
		return ResponseEntity.ok(Constantes.MESSAGE_REGISTER_DELETE);
	}

	
}
