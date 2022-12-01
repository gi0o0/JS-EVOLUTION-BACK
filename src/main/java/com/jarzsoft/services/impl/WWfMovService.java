package com.jarzsoft.services.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.entities.W_Wf_Pas_Aut;
import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.mapper.IWWfMovMapper;
import com.jarzsoft.repository.WWfMovRepository;
import com.jarzsoft.repository.W_Wf_Pas_AutRepository;
import com.jarzsoft.repository.W_Wf_PasosRepository;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumWF;
import com.jarzsoft.util.SendEmail;

@Service
public class WWfMovService implements IWWfMovService {

	private final WWfMovRepository wWfMovRepository;

	private final IWWfMovMapper mapper;

	private final W_Wf_PasosRepository wWfPasosRepository;

	private final SendEmail sendEmail;

	private final W_Wf_Pas_AutRepository w_Wf_Pas_AutRepository;

	@Autowired
	public WWfMovService(WWfMovRepository wWfMovRepository, IWWfMovMapper mapper,
			W_Wf_PasosRepository wWfPasosRepository, SendEmail sendEmail,
			W_Wf_Pas_AutRepository w_Wf_Pas_AutRepository) {
		super();
		this.wWfMovRepository = wWfMovRepository;
		this.mapper = mapper;
		this.wWfPasosRepository = wWfPasosRepository;
		this.sendEmail = sendEmail;
		this.w_Wf_Pas_AutRepository = w_Wf_Pas_AutRepository;
	}

	@Override
	public DTOWWfMov create(DTOWWfMov o) {

		WWfMov oldMov = findMovByNumRad(o.getNumeroRadicacion(), o.getIdWf() + "", o.getIdPaso());

		if (oldMov == null) {
			o.setIdWfMov(wWfMovRepository.getKey());
		} else {
			o.setIdWfMov(oldMov.getIdWfMov());
		}

		oldMov = wWfMovRepository.save(mapper.mapperDtoToEntitie(o));
		return mapper.mapperEntitieToDao(oldMov);
	}

	@Override
	public WWfMov findMovByNumRad(Integer numero_radicacion, String id_wf, String id_paso) {
		return wWfMovRepository.findMovByNumRad(numero_radicacion, id_wf, id_paso);
	}

	@Override
	public DTOWWfMov createMovWithSteps(DTOSolCredito out, String user, String stepValue,Boolean isUpdate) {

		W_Wf_Pasos step = wWfPasosRepository.findByIdStep(stepValue);
		DTOWWfMov mov = null;
		if (null != step) {
			
			if(!isUpdate) {
			if (Constantes.isOK.equals(step.getEnvCorreoPaso())) {
				sendEmail.Send(step.getEmail1(), step.getAsuntoCorreo(), step.getTextoCorreo());
				sendEmail.Send(step.getEmail2(), step.getAsuntoCorreo(), step.getTextoCorreo());
			}
			if (Constantes.isOK.equals(step.getEnvCorreoAutoriza())) {
				sendEmail.Send(step.getEmail3(), step.getAsuntoCorreo(), step.getTextoCorreo());
				sendEmail.Send(step.getEmail2(), step.getAsuntoCorreo(), step.getTextoCorreo());
			}
			}

			List<W_Wf_Pas_Aut> auts = w_Wf_Pas_AutRepository.findByWfAndStep(EnumWF.TIPO_WF.IDWF_4.getName(),
					stepValue);
			HashMap<String, String> users = new HashMap<String, String>();

			for (int i = 0; i < auts.size(); i++) {
				int j = i + 1;
				users.put("user" + j, auts.get(i).getW_Wf_Pas_AutPK().getUsuario());
			}
			
			mov = create(mapper.mapperDaoToDto(out, step, user, Integer.parseInt(EnumWF.TIPO_WF.IDWF_4.getName()), null,
					stepValue, users));

		}
		return mov;
	}

	@Override
	public DTOWWfMov findMovByNumRadAndStep(Integer numero_radicacion, String id_wf, String id_paso) {
		return mapper.mapperEntitieToDao(wWfMovRepository.findMovByNumRad(numero_radicacion, id_wf, id_paso));
	}

	@Override
	public Integer findMaxMovByNumRad(Integer numero_radicacion, String id_wf) {
		return wWfMovRepository.findMaxMovByNumRad(numero_radicacion, id_wf);
	}
	
	

}
