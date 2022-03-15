
package com.jarzsoft.service;

import org.springframework.http.ResponseEntity;

import com.jarzsoft.dto.DTOFosececo;


public interface IFosececoService extends ICRUD<DTOFosececo> {
	
	ResponseEntity<Object> delete(String codSec);
 	 
}
