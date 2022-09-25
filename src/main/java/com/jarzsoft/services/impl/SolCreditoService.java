package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.entities.SolCredito;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.repository.SolCreditoRepository;
import com.jarzsoft.service.ISolCreditoService;

@Service
public class SolCreditoService implements ISolCreditoService {

	private final SolCreditoRepository solCreditoRepository;

	private final ISolCreditoMapper mapper;

	@Autowired
	public SolCreditoService(SolCreditoRepository solCreditoRepository, ISolCreditoMapper mapper) {
		super();
		this.solCreditoRepository = solCreditoRepository;
		this.mapper = mapper;
	}

	@Override
	public DTOSolCredito create(DTOSolCredito o) {
		SolCredito credito = findTerByNiter(o.getCodTer(), o.getTipoCredito());

		if (credito == null) {
			o.setNumeroRadicacion(solCreditoRepository.getKey());
		} else {
			o.setNumeroRadicacion(credito.getNumeroRadicacion());
			o.setFechaSoli(credito.getFechaSoli());
		}

		credito = solCreditoRepository.save(mapper.mapperDtoToEntitie(o));

		return mapper.mapperEntitieToDao(credito);
	}

	@Override
	public DTOSolCredito findByNiter(String nitTer, String tipoCredito) {
		return mapper.mapperEntitieToDao(findTerByNiter(nitTer, tipoCredito));
	}

	private SolCredito findTerByNiter(String nitTer, String tipoCredito) {
		return solCreditoRepository.findByNiter(nitTer, tipoCredito);
	}

	@Override
	public Integer updateState(Integer numeroRadicacion, String estado) {
		solCreditoRepository.modificarEstado(numeroRadicacion, estado);
		return numeroRadicacion;
	}

	@Override
	public DTOSolCredito findBynumeroRadicacion(Integer numeroRadicacion) {
		return mapper.mapperEntitieToDao(solCreditoRepository.findByNumRad(numeroRadicacion + ""));
	}

	@Override
	public String modificarClaveLink(Integer numeroRadicacion, String hash) {
		solCreditoRepository.modificarClaveLink(numeroRadicacion + "", hash);
		return hash;
	}

	@Override
	public DTOSolCredito findByHash(String hash) {
		return mapper.mapperEntitieToDao(solCreditoRepository.findByHash(hash));
	}

	@Override
	public List<DTOSolCredito> findByUser(String user) {
		return mapper.mapperEntitiesToDaos(solCreditoRepository.findByUser(user));
	}

}
