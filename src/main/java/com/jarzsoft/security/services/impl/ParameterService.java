package com.jarzsoft.security.services.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOParameter;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.entities.ParametroKey;
import com.jarzsoft.mapper.IParameterMapper;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IParameterService;

@Service
public class ParameterService implements IParameterService {

	private final ParametroRepository dao;

	private final IParameterMapper mapper;

	public ParameterService(ParametroRepository dao, IParameterMapper mapper) {
		super();
		this.dao = dao;
		this.mapper = mapper;

	}

	public DTOParameter create(DTOParameter t) {
		return mapper.mapperDaoToDto(dao.save(mapper.mapperDtoToDao(t)));

	}

	public DTOParameter update(DTOParameter t) {
		Parametro o = new Parametro(new ParametroKey(t.getId(), t.getText()), t.getValue());
		return mapper.mapperDaoToDto(dao.save(o));
	}

	public List<DTOParameter> listAll() {
		return mapper.mapperList(dao.findAll());
	}

	@Override
	public ResponseEntity<Object> delete(int id) {
		return null;
	}

	public DTOParameter listById(int id) {
		return null;
	}

	@Override
	public DTOParameter delete(DTOParameter t) {
		dao.delete(mapper.mapperDtoToDao(t));
		return t;
	}

}
