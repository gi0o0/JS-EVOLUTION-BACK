package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOOpciones;
import com.jarzsoft.dto.DTOOpcionesPerfil;
import com.jarzsoft.dto.DTOSystem;

public interface ISystemService {

	List<DTOSystem> listAll();

	List<DTOOpciones> listOpciones(String idSystem, String idPerfil);

	DTOOpcionesPerfil createOption(DTOOpcionesPerfil t);

	boolean deleteOption(String idOption, String idRole);

}
