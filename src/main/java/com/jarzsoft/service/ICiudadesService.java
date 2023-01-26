package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOCiudad;

public interface ICiudadesService {

	List<DTOCiudad> getAll(Integer idPais, Integer idDeptos);
	
	DTOCiudad getCiudad(Integer idCiudad);

}
