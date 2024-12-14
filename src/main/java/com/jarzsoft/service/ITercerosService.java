package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOTerceros;

public interface ITercerosService {

	DTOTerceros create(DTOTerceros o, String user, boolean isCodeo);

	DTOTerceros findByNiter(String nitTer);

	DTOTerceros findByCodter(String codTer);

	List<DTOTerceros> getAsesores();
	
	String modificarClaveLink(String nitTer, String hash);

	DTOTerceros findByHash(String hash);
	
	DTOTerceros findByNiterAndSchema(String scheme, String nitTer);
}
