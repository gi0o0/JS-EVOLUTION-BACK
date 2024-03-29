package com.jarzsoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOW_Bas_Usuario;

public interface IUserWebService extends ICRUD<DTOW_Bas_Usuario> {

	ResponseEntity<Object> delete(String usuario);

	List<DTOW_Bas_Usuario> listAllObj();

	DTOW_Bas_Usuario getUserById(String id);

	List<DTOTerceros> getAsesores();

}
