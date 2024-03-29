package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
		out.setEstPasoMov(o.getEstPasoMov());
		out.setNitTer(o.getNitTer());

		return out;
	}

	@Override
	public DTOWWfMov mapperEntitieToDao(WWfMov o) {
		DTOWWfMov out = new DTOWWfMov();
		if (null != o) {
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
			out.setEstPasoMov(o.getEstPasoMov());
			out.setNitTer(o.getNitTer());
			out.setUsuComercial(o.getUsuComercial());
			out.setFecUltMod(o.getFecUltMod());
		}
		return out;
	}

	@Override
	public DTOWWfMov mapperDaoToDto(DTOSolCredito o, W_Wf_Pasos p, String user, Integer idWf, Integer id, String idPaso,
			HashMap<String, String> users) {
		DTOWWfMov out = new DTOWWfMov();
		out.setAdjDocumentos(p.getSolDocumentos());
		out.setCieSigPaso(idPaso);
		out.setCodTer(o.getCodeudor1());
		out.setComentarios(o.getObserva());
		out.setEmail1(p.getEmail1());
		out.setEmail2(p.getEmail2());
		out.setEmail3(p.getEmail3());
		out.setEmail4(p.getEmail3());
		out.setEnEspera(p.getSolAutoriza() == null || p.getSolAutoriza().equals("false") ? "N" : "S");
		out.setEnvCorreo(p.getEnvCorreoPaso() == null || p.getEnvCorreoPaso().equals("false") ? "N" : "S");
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
		out.setEstPasoMov(o.getTipSolcredito());
		out.setNitTer(o.getCodTer());
		return out;
	}

	@Override
	public List<DTOWWfMov> mapperEntitieLisToDaoList(List<WWfMov> list) {
		List<DTOWWfMov> response = new ArrayList<DTOWWfMov>();
		list.stream().forEach(o -> {
			response.add(mapperEntitieToDao(o));
		});

		return response;
	}

	@Override
	public List<DTOWWfMov> mapperEntitieLisToDaoListCustom(List<Object[]> o) {

		List<DTOWWfMov> response = new ArrayList<DTOWWfMov>();

		o.stream().forEach(obj -> {
			DTOWWfMov mov = new DTOWWfMov();
			mov.setIdWf(Integer.parseInt(obj[0] + ""));
			mov.setIdPaso(obj[1] + "");
			mov.setComentarios(obj[2] + "");
			mov.setEstPaso(obj[3] + "");
			mov.setNumeroRadicacion((int) Double.parseDouble(obj[4] + ""));
			mov.setIdWfMov(Integer.parseInt(obj[5] + ""));
			mov.setNitTer(obj[6] + "");
			mov.setNameWf(obj[7] + "");
			mov.setNamePaso(obj[8] + "");
		    mov.setFecUltMod((Date) obj[9]);
		    mov.setUsuComercial(obj[10] + "");
		    mov.setNomTer(obj[11] + "");
	
			response.add(mov);

		});

		return response;
	}

}
