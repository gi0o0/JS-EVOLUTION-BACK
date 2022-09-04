package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFotabpro;
import com.jarzsoft.mapper.IFotabproMapper;
import com.jarzsoft.repository.FotabproRepository;
import com.jarzsoft.service.IFotabproService;

@Service
public class FotabproService implements IFotabproService {

	private final FotabproRepository fotabproRepository;

	private final IFotabproMapper fotabproMapper;

	@Autowired
	public FotabproService(FotabproRepository fotabproRepository, IFotabproMapper fotabproMapper) {
		super();
		this.fotabproRepository = fotabproRepository;
		this.fotabproMapper = fotabproMapper;

	}

	@Override
	public List<DTOFotabpro> getAll() {
		return fotabproMapper.mapperList(fotabproRepository.findAll());
	}

}
