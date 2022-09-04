package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOFoclaaso;

public interface IFoclaasoService {

	List<DTOFoclaaso> getCompaniesByUser(String user);

}
