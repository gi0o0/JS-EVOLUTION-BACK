package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOFilesUser;

public interface IFilesUserService {

	List<DTOFilesUser> listAll(String user, String solicitud, String id);

}
