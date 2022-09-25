package com.jarzsoft.service;

import com.jarzsoft.dto.DTOFodataso;

public interface IFodatasoService {

	DTOFodataso create(DTOFodataso o);
	
	DTOFodataso getByCodTer(String codTer);

}
