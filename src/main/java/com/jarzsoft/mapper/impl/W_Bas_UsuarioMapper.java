package com.jarzsoft.mapper.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOOpciones;
import com.jarzsoft.dto.DTOW_Bas_Usuario;
import com.jarzsoft.entities.Fosececo;
import com.jarzsoft.entities.W_Bas_Usuario;
import com.jarzsoft.mapper.IW_Bas_UsuarioMapper;

@Service
public class W_Bas_UsuarioMapper implements IW_Bas_UsuarioMapper {

	@Override
	public List<DTOW_Bas_Usuario> mapperList(List<W_Bas_Usuario> list) {
		List<DTOW_Bas_Usuario> response = new ArrayList<DTOW_Bas_Usuario>();
		list.stream().forEach(o -> {
			response.add(new DTOW_Bas_Usuario(o.getUsuario(), o.getNom_usuario(), o.getClave(), o.getCodTer(),
					o.getClave1(), o.getClave_link(), o.getClave_global(), o.getDate_mod(), o.getClave_umbral(),
					o.getClave_global_his(), o.getTipoAut(), o.getCodPerfil(), o.getUsuUltMod(), o.getFecUltMod(),
					o.getFecCrea(), o.getUsuCrea(), o.getEstado()));

		});

		return response;
	}
	
	@Override
	public List<DTOW_Bas_Usuario> mapperListObj(List<Object[]> list) {
		List<DTOW_Bas_Usuario> response = new ArrayList<DTOW_Bas_Usuario>();
		list.stream().forEach(o -> {
			BigDecimal x = null;
			//x = new BigDecimal((BigInteger) o[3] );
			//x = new BigDecimal(o[3].toString() );
			
			  response.add(new DTOW_Bas_Usuario( String.valueOf(o[0]),String.valueOf(o[1]),Integer.parseInt(o[3].toString()), String.valueOf(o[5]), Integer.parseInt(o[6].toString()) ,String.valueOf(o[7])));
			  //String usuario 0, String nom_usuario 1, int codter 3, String estado 5, int codPerfil 6, String nomperfil 7
			  //bigdecimal  short
			  
			  
			});

		return response;
		
	 
	}

	@Override
	public DTOW_Bas_Usuario mapperDaoToDto(W_Bas_Usuario o) {
		return new DTOW_Bas_Usuario(o.getUsuario(), o.getNom_usuario(), o.getClave(), o.getCodTer(), o.getClave1(),
				o.getClave_link(), o.getClave_global(), o.getDate_mod(), o.getClave_umbral(), o.getClave_global_his(),
				o.getTipoAut(), o.getCodPerfil(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea(),
				o.getEstado());
	}

	@Override
	public W_Bas_Usuario mapperDtoToDao(DTOW_Bas_Usuario o) {
		return new W_Bas_Usuario(o.getUsuario(), o.getNom_usuario(), o.getClave(), o.getCodTer(), o.getClave1(),
				o.getClave_link(), o.getClave_global(), o.getDate_mod(), o.getClave_umbral(), o.getClave_global_his(),
				o.getTipoAut(), o.getCodPerfil(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea(),
				o.getEstado());
	}
	
	@Override
	public W_Bas_Usuario mapperDtoToDao(String o) {

		return new W_Bas_Usuario(o);
	}

}
