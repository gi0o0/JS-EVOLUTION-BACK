package com.jarzsoft.service;

import com.jarzsoft.dto.DTOSolCredito;

public interface ISolCreditoService {

	DTOSolCredito create(DTOSolCredito o);

	Integer updateState(Integer numeroRadicacion, String estado);

	DTOSolCredito findByNiter(String nitTer, String tipoCredito);

	DTOSolCredito findBynumeroRadicacion(Integer numeroRadicacion);

	DTOSolCredito findByHash(String hash);

	String modificarClaveLink(Integer numeroRadicacion, String hash);

}
