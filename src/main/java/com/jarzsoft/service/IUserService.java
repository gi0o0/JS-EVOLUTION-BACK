package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOUser;

public interface IUserService {

	String getInternalUser(String id);

	List<DTOUser> listAll();
	
	List<DTOUser> sync();

	DTOUser create(DTOUser user);

	DTOUser updateProfile(DTOUser user);

	DTOTerceros findByNiter(String nitTer);

}
