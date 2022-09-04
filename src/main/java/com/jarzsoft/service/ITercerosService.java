package com.jarzsoft.service;

import com.jarzsoft.dto.DTOTerceros;

public interface ITercerosService {

	DTOTerceros create(DTOTerceros o, String user);

	DTOTerceros findByNiter(String nitTer);
	
	DTOTerceros findByCodter(String codTer);

}
