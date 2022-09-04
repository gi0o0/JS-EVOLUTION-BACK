package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTODeptos;

public interface IDeptosService {

	List<DTODeptos> getAll(Integer id);

}
