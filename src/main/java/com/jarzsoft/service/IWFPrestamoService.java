package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOWFPrestamos;

public interface IWFPrestamoService {

	DTOWFPrestamos create(DTOWFPrestamos o);

	List<DTOWFPrestamos> getByWfAndNumRad(Integer id, Integer num_rad);


}
