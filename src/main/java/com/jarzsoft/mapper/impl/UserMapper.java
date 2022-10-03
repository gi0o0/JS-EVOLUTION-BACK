package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IUserMapper;
import com.jarzsoft.util.Comunes;

@Service
public class UserMapper implements IUserMapper {

	@Override
	public List<DTOUser> mapperList(List<W_Bas_Usuario> list) {
		List<DTOUser> response = new ArrayList<DTOUser>();
		list.stream().forEach(o -> {
			response.add(new DTOUser(Comunes.stringClean(o.getUsuario()), o.getNom_usuario(), o.getCodPerfil() + "",
					o.getEstado()));
		});

		return response;
	}

	@Override
	public DTOUser mapperDaoToDto(W_Bas_Usuario o) {
		return new DTOUser(o.getUsuario(), o.getNom_usuario(), o.getCodPerfil() + "", o.getEstado());
	}

	@Override
	public W_Bas_Usuario mapperDtoToDao(DTOUser o) {
		W_Bas_Usuario out = new W_Bas_Usuario();
		out.setUsuario(o.getId());
		out.setCodPerfil(Comunes.stringToInteger(o.getIdProfile()));
		out.setNom_usuario(o.getName());
		out.setEstado(o.getEstado());
		out.setCodTer(o.getCodTer());
		return out;
	}

}
