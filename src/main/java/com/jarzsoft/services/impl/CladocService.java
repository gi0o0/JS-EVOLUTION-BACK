package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOCladoc;
import com.jarzsoft.mapper.ICladocMapper;
import com.jarzsoft.repository.CladocRepository;
import com.jarzsoft.service.ICladocService;

@Service
public class CladocService implements ICladocService {

	private final CladocRepository cladocRepository;

	private final ICladocMapper cladocMapper;

	@Autowired
	public CladocService(CladocRepository cladocRepository, ICladocMapper cladocMapper) {
		super();
		this.cladocRepository = cladocRepository;
		this.cladocMapper = cladocMapper;

	}

	@Override
	public List<DTOCladoc> getAll() {
		return cladocMapper.mapperList(cladocRepository.findAll());
	}

}
