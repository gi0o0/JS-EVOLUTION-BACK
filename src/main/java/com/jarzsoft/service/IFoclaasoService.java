package com.jarzsoft.service;

import java.math.BigInteger;
import java.util.List;

import com.jarzsoft.dto.DTOFoclaaso;

public interface IFoclaasoService {

	List<DTOFoclaaso> getCompaniesByUser(String user);

	DTOFoclaaso getCompaniesByID(BigInteger id);

	List<DTOFoclaaso> getAllCompanies();

}
