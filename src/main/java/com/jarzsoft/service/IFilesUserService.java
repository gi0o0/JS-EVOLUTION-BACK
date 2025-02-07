package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOFilesUser;
import com.jarzsoft.dto.DTOWfDocs;

public interface IFilesUserService {

	List<DTOFilesUser> listAll(String user, String solicitud, String id, String name);

	List<DTOFilesUser> listAllByIdRedAndStep(String solicitud, String step);

	List<DTOFilesUser> listAllById(String solicitud);

	Boolean create(String id, String step, String cedula, DTOWfDocs documento);

}
