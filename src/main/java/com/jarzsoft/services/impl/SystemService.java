package com.jarzsoft.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOOpciones;
import com.jarzsoft.dto.DTOOpcionesPerfil;
import com.jarzsoft.dto.DTOSystem;
import com.jarzsoft.mapper.ISystemMapper;
import com.jarzsoft.repository.W_Bas_T_Per_OpcionRepository;
import com.jarzsoft.repository.W_Men_OpcionRepository;
import com.jarzsoft.repository.W_SistemasRepository;
import com.jarzsoft.service.ISystemService;
import com.jarzsoft.service.IUserService;

@Service
public class SystemService implements ISystemService {

	private final W_SistemasRepository dao;

	private final W_Bas_T_Per_OpcionRepository w_Bas_T_Per_Opcion;

	private final ISystemMapper mapper;

	private final W_Men_OpcionRepository opcionRepository;

	private final IUserService usuarioService;

	@Autowired
	public SystemService(W_SistemasRepository dao, ISystemMapper mapper, W_Men_OpcionRepository opcionRepository,
			IUserService usuarioService, W_Bas_T_Per_OpcionRepository w_Bas_T_Per_Opcion) {
		super();
		this.dao = dao;
		this.mapper = mapper;
		this.opcionRepository = opcionRepository;
		this.usuarioService = usuarioService;
		this.w_Bas_T_Per_Opcion = w_Bas_T_Per_Opcion;

	}

	@Override
	public List<DTOSystem> listAll() {
		return mapper.mapperList(dao.findAll());
	}

	@Override
	public List<DTOOpciones> listOpciones(String idSystem, String idPerfil) {
		List<Object[]> opciones = opcionRepository.findOpcionesBySystem(idSystem, idPerfil);
		List<DTOOpciones> response = new ArrayList<>();
		for (Object[] obj : opciones) {
			String enabled = String.valueOf(obj[2]);
			response.add(new DTOOpciones(String.valueOf(obj[0]), String.valueOf(obj[1]),
					!enabled.equals("null") ? "true" : "false"));
		}

		return response;
	}

	@Override
	public DTOOpcionesPerfil createOption(DTOOpcionesPerfil t) {

		t.setUsuCrea(usuarioService.getInternalUser(t.getUsuCrea()));
		t.setFecCrea(new Date());
		return mapper.mapperDaoToDtoOpc(w_Bas_T_Per_Opcion.save(mapper.mapperDtoToDaoOpc(t)));
	}

	@Override
	public boolean deleteOption(String idOption, String idRole) {

		w_Bas_T_Per_Opcion.delete(mapper.mapperDtoToDaoOpc(idOption, idRole));

		return true;
	}

}
