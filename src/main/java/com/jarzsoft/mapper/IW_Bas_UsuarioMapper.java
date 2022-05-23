package com.jarzsoft.mapper;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jarzsoft.dto.DTOW_Bas_Usuario;
import com.jarzsoft.entities.Fosececo;
import com.jarzsoft.entities.W_Bas_Usuario;

@Service
public interface IW_Bas_UsuarioMapper {

	public List<DTOW_Bas_Usuario> mapperList(List<W_Bas_Usuario> list);

	public DTOW_Bas_Usuario mapperDaoToDto(W_Bas_Usuario o);

	public W_Bas_Usuario mapperDtoToDao(DTOW_Bas_Usuario o);
	
	public W_Bas_Usuario mapperDtoToDao(String o);
	
	public List<DTOW_Bas_Usuario> mapperListObj(List<Object[]> list);

}

