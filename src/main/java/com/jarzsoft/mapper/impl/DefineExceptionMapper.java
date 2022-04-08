package com.jarzsoft.mapper.impl;

import com.jarzsoft.util.Constantes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.jarzsoft.mapper.IDefineExceptionMapper;

@Service
public class DefineExceptionMapper implements IDefineExceptionMapper {

	@Override
	public String mapperExToString(Exception ex) {
		String var = Constantes.MESSAGE_DEFAULT_ERROR;

		if (ex instanceof TransactionSystemException) {
			//var = Constantes.MESSAGE_PERSIST_ERROR + '-' + ex.getMessage();
			var = Constantes.MESSAGE_PERSIST_ERROR ;
		}

		return var;
	}

}
