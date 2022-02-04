package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.entities.W_Bas_T_Perfil;
import com.jarzsoft.mapper.IProfileMapper;

@Service
public class ProfileMapper implements IProfileMapper {

	@Override
	public List<DTOProfile> mapperList(List<W_Bas_T_Perfil> list) {
		List<DTOProfile> response = new ArrayList<DTOProfile>();
		list.stream().forEach(o -> {
			response.add(new DTOProfile(o.getCodPerfil() + "", o.getNomPerfil(), o.getUsuUltMod(), o.getFecUltMod(),
					o.getFecCrea(), o.getUsuCrea()));
		});

		return response;
	}

	@Override
	public DTOProfile mapperDaoToDto(W_Bas_T_Perfil o) {
		return new DTOProfile(o.getCodPerfil() + "", o.getNomPerfil(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

	@Override
	public W_Bas_T_Perfil mapperDtoToDao(DTOProfile o) {

		return new W_Bas_T_Perfil(Long.parseLong(o.getId()), o.getName(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

}
