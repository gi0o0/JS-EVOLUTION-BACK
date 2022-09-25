package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOSolCredito;

public interface ISolCreditoService {

	DTOSolCredito create(DTOSolCredito o);

	Integer updateState(Integer numeroRadicacion, String estado);

	DTOSolCredito findByNiter(String nitTer, String tipoCredito);

	DTOSolCredito findBynumeroRadicacion(Integer numeroRadicacion);

	List<DTOSolCredito> findByUser(String user);

	DTOSolCredito findByHash(String hash);

	String modificarClaveLink(Integer numeroRadicacion, String hash);

}
