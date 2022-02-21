package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.entities.W_Bas_Usuario;

public interface IUserMapper {

	public List<DTOUser> mapperList(List<W_Bas_Usuario> list);

	public DTOUser mapperDaoToDto(W_Bas_Usuario o);


}
