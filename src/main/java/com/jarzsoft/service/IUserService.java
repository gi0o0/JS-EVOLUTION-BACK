package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOUser;

public interface IUserService {

	String getInternalUser(String id);

	List<DTOUser> listAll();

	DTOUser updateProfile(DTOUser user);

}
