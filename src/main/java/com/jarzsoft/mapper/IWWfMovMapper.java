package com.jarzsoft.mapper;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.entities.W_Wf_Pasos;

@Service
public interface IWWfMovMapper {

	public WWfMov mapperDtoToEntitie(DTOWWfMov o);

	public DTOWWfMov mapperEntitieToDao(WWfMov o);

	public DTOWWfMov mapperDaoToDto(DTOSolCredito o, W_Wf_Pasos p, String user,Integer idWf,Integer id,String idPaso, HashMap<String, String> users);

}
