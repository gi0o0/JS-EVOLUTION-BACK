package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOCiudades;

public interface ICiudadesService {

	List<DTOCiudades> getAll(Integer idPais, Integer idDeptos);

}
