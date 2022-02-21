package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOOpcionesPerfil;
import com.jarzsoft.dto.DTOSystem;
import com.jarzsoft.entities.W_Bas_T_Per_Opcion;
import com.jarzsoft.entities.W_sistemas;

public interface ISystemMapper {

	public List<DTOSystem> mapperList(List<W_sistemas> list);

	public DTOOpcionesPerfil mapperDaoToDtoOpc(W_Bas_T_Per_Opcion o);

	public W_Bas_T_Per_Opcion mapperDtoToDaoOpc(DTOOpcionesPerfil o);
	
	public W_Bas_T_Per_Opcion mapperDtoToDaoOpc(String idOption, String idRole);

}
