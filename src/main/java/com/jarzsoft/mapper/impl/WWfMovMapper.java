package com.jarzsoft.mapper.impl;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.mapper.IWWfMovMapper;

@Service
public class WWfMovMapper implements IWWfMovMapper {

	@Override
	public WWfMov mapperDtoToEntitie(DTOWWfMov o) {
		WWfMov out = new WWfMov();
		out.setAdjDocumentos(o.getAdjDocumentos());
		out.setCieSigPaso(o.getCieSigPaso());
		out.setCifin(o.getCifin());
		out.setCodTer(o.getCodTer());
		out.setComentarios(o.getComentarios());
		out.setDatajuridico(o.getDatajuridico());
		out.setEmail1(o.getEmail1());
		out.setEmail2(o.getEmail2());
		out.setEmail3(o.getEmail3());
		out.setEmail4(o.getEmail4());
		out.setEnEspera(o.getEnEspera());
		out.setEnvCorreo(o.getEnvCorreo());
		out.setEstPaso(o.getEstPaso());
		out.setFecEnvio(o.getFecEnvio());
		out.setIdWf(o.getIdWf());
		out.setIdWfMov(o.getIdWfMov());
		out.setIdPaso(o.getIdPaso());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setResCifin(o.getResCifin());
		out.setResDatajuridico(o.getResDatajuridico());
		out.setUsuario1(o.getUsuario1());
		out.setUsuario1Task(o.getUsuario1Task());
		out.setUsuario1Vobo(o.getUsuario1Vobo());
		out.setUsuario2(o.getUsuario2());
		out.setUsuario2Task(o.getUsuario2Task());
		out.setUsuario2Vobo(o.getUsuario2Vobo());
		out.setUsuario3(o.getUsuario3());
		out.setUsuario3Task(o.getUsuario3Task());
		out.setUsuario3Vobo(o.getUsuario3Vobo());
		out.setUsuario4(o.getUsuario4());
		out.setUsuario4Task(o.getUsuario4Task());
		out.setUsuario4Vobo(o.getUsuario4Vobo());
		out.setUsuComercial(o.getUsuComercial());
		out.setUsuComercialTask(o.getUsuComercialTask());
		out.setUsuComercialVobo(o.getUsuComercialVobo());
		out.setUsuMovimiento(o.getUsuMovimiento());

		return out;
	}

	@Override
	public DTOWWfMov mapperEntitieToDao(WWfMov o) {
		DTOWWfMov out = new DTOWWfMov();
		if(null!=o) {
		out.setAdjDocumentos(o.getAdjDocumentos());
		out.setCieSigPaso(o.getCieSigPaso());
		out.setCifin(o.getCifin());
		out.setCodTer(o.getCodTer());
		out.setComentarios(o.getComentarios());
		out.setDatajuridico(o.getDatajuridico());
		out.setEmail1(o.getEmail1());
		out.setEmail2(o.getEmail2());
		out.setEmail3(o.getEmail3());
		out.setEmail4(o.getEmail4());
		out.setEnEspera(o.getEnEspera());
		out.setEnvCorreo(o.getEnvCorreo());
		out.setEstPaso(o.getEstPaso());
		out.setFecEnvio(o.getFecEnvio());
		out.setIdWf(o.getIdWf());
		out.setIdWfMov(o.getIdWfMov());
		out.setIdPaso(o.getIdPaso());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setResCifin(o.getResCifin());
		out.setResDatajuridico(o.getResDatajuridico());
		out.setUsuario1(o.getUsuario1());
		out.setUsuario1Task(o.getUsuario1Task());
		out.setUsuario1Vobo(o.getUsuario1Vobo());
		out.setUsuario2(o.getUsuario2());
		out.setUsuario2Task(o.getUsuario2Task());
		out.setUsuario2Vobo(o.getUsuario2Vobo());
		out.setUsuario3(o.getUsuario3());
		out.setUsuario3Task(o.getUsuario3Task());
		out.setUsuario3Vobo(o.getUsuario3Vobo());
		out.setUsuario4(o.getUsuario4());
		out.setUsuario4Task(o.getUsuario4Task());
		out.setUsuario4Vobo(o.getUsuario4Vobo());
		out.setUsuComercial(o.getUsuComercial());
		out.setUsuComercialTask(o.getUsuComercialTask());
		out.setUsuComercialVobo(o.getUsuComercialVobo());
		out.setUsuMovimiento(o.getUsuMovimiento());
		}
		return out;
	}

	@Override
	public DTOWWfMov mapperDaoToDto(DTOSolCredito o, W_Wf_Pasos p, String user, Integer idWf, Integer id,
			String idPaso, HashMap<String, String> users) {
		DTOWWfMov out = new DTOWWfMov();
		out.setAdjDocumentos(p.getSolDocumentos());
		out.setCieSigPaso(idPaso);
		out.setCodTer(o.getCodeudor1());
		out.setComentarios(o.getObserva());
		out.setEmail1(p.getEmail1());
		out.setEmail2(p.getEmail2());
		out.setEmail3(p.getEmail3());
		out.setEmail4(p.getEmail3());
		out.setEnEspera(p.getSolAutoriza());
		out.setEnvCorreo(p.getEnvCorreoPaso());
		out.setEstPaso(o.getEstado());
		out.setFecEnvio(new Date());
		out.setIdWf(idWf);
		out.setIdWfMov(id);
		out.setIdPaso(idPaso);
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setUsuario1(users.get("user1"));
		out.setUsuario2(users.get("user2"));
		out.setUsuario3(users.get("user3"));
		out.setUsuario4(users.get("user4"));
		out.setUsuComercial(user);
		out.setUsuMovimiento(user);
		return out;
	}

}
