package com.jarzsoft.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jarzsoft.entities.Folog;
import com.jarzsoft.mapper.IProfileMapper;
import com.jarzsoft.repository.FologRepository;
import com.jarzsoft.repository.UsuariosRepository;
import com.jarzsoft.service.IFologService;

@Service
public class FologService implements IFologService {

	private final FologRepository fologRepository;

	@Autowired
	public FologService(FologRepository fologRepository, IProfileMapper mapper, UsuariosRepository usuario) {
		super();
		this.fologRepository = fologRepository;

	}

	@Async
	@Override
	public Folog create(Folog log) {

		return fologRepository.save(log);
	}

}
