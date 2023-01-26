package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOBaentidad;

public interface IBaEntidadService {

	List<DTOBaentidad> getAll();

	DTOBaentidad getBaentidad(String id);

}
