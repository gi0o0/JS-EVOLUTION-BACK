package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.entities.W_Bas_T_Perfil;

public interface IProfileMapper {

	public List<DTOProfile> mapperList(List<W_Bas_T_Perfil> list);
	
	public DTOProfile mapperDaoToDto(W_Bas_T_Perfil o);
	
	public W_Bas_T_Perfil mapperDtoToDao(DTOProfile o);

}
