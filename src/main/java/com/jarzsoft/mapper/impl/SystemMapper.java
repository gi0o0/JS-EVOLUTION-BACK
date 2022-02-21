package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOOpcionesPerfil;
import com.jarzsoft.dto.DTOSystem;
import com.jarzsoft.entities.W_Bas_T_Per_Opcion;
import com.jarzsoft.entities.W_Bas_T_Per_OpcionPK;
import com.jarzsoft.entities.W_sistemas;
import com.jarzsoft.mapper.ISystemMapper;

@Service
public class SystemMapper implements ISystemMapper {

	@Override
	public List<DTOSystem> mapperList(List<W_sistemas> list) {
		List<DTOSystem> response = new ArrayList<DTOSystem>();
		list.stream().forEach(o -> {
			response.add(new DTOSystem(o.getNumero_sistema() + "", o.getNombre_sistema().trim()));
		});

		return response;
	}

	@Override
	public DTOOpcionesPerfil mapperDaoToDtoOpc(W_Bas_T_Per_Opcion o) {
		return new DTOOpcionesPerfil(o.getW_Bas_T_Per_OpcionPK().getCodOpcion() + "",
				o.getW_Bas_T_Per_OpcionPK().getCodPerfil() + "", o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(),
				o.getUsuCrea());
	}

	@Override
	public W_Bas_T_Per_Opcion mapperDtoToDaoOpc(DTOOpcionesPerfil o) {
		return new W_Bas_T_Per_Opcion(
				new W_Bas_T_Per_OpcionPK(Integer.parseInt(o.getIdRole()), Integer.parseInt(o.getIdOption())),
				o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea());
	}

	@Override
	public W_Bas_T_Per_Opcion mapperDtoToDaoOpc(String idOption, String idRole) {
		return new W_Bas_T_Per_Opcion(new W_Bas_T_Per_OpcionPK(Integer.parseInt(idRole), Integer.parseInt(idOption)),
				null, null, null, null);
	}

}
