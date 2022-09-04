package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFotipcre;
import com.jarzsoft.mapper.IFotipcreMapper;
import com.jarzsoft.repository.FotipcreRepository;
import com.jarzsoft.service.IFotipcreService;

@Service
public class FotipcreService implements IFotipcreService {

	private final FotipcreRepository fotipcreRepository;

	private final IFotipcreMapper fotipcreMapper;

	@Autowired
	public FotipcreService(FotipcreRepository fotipcreRepository, IFotipcreMapper fotipcreMapper) {
		super();
		this.fotipcreRepository = fotipcreRepository;
		this.fotipcreMapper = fotipcreMapper;

	}

	@Override
	public List<DTOFotipcre> getAll() {
		return fotipcreMapper.mapperList(fotipcreRepository.findAll());
	}

}
