package com.jarzsoft.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Folog create(Folog log) {

		return fologRepository.save(log);
	}

}
