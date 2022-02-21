package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IUserMapper;

@Service
public class UserMapper implements IUserMapper {

	@Override
	public List<DTOUser> mapperList(List<W_Bas_Usuario> list) {
		List<DTOUser> response = new ArrayList<DTOUser>();
		list.stream().forEach(o -> {
			response.add(new DTOUser(o.getUsuario(), o.getNom_Usuario(), o.getCodPerfil() + ""));
		});

		return response;
	}

	@Override
	public DTOUser mapperDaoToDto(W_Bas_Usuario o) {
		return new DTOUser(o.getUsuario(), o.getNom_Usuario(), o.getCodPerfil() + "");
	}

}
