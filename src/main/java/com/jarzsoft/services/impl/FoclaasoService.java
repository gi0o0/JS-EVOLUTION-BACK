package com.jarzsoft.services.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFoclaaso;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IFoclaasoMapper;
import com.jarzsoft.repository.FoclaasoRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IFoclaasoService;

@Service
public class FoclaasoService implements IFoclaasoService {

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final FoclaasoRepository foclaasoRepository;

	private final IFoclaasoMapper foclaasoMapper;

	@Autowired
	public FoclaasoService(W_Bas_UsuarioRepository usuarioRepository, FoclaasoRepository foclaasoRepository,
			IFoclaasoMapper foclaasoMapper) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.foclaasoRepository = foclaasoRepository;
		this.foclaasoMapper = foclaasoMapper;

	}

	@Override
	public List<DTOFoclaaso> getCompaniesByUser(String user) {

		W_Bas_Usuario adviser = usuarioRepository.loadUserByUsername(user);

		return foclaasoMapper.mapperList(foclaasoRepository.findByUsuario(String.valueOf(adviser.getCodTer())));

	}

	@Override
	public DTOFoclaaso getCompaniesByID(BigInteger id) {
		return foclaasoMapper.mapperEntitieToDto(foclaasoRepository.findById(id).get());
	}

}
