package com.jarzsoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StorageException(String mensaje) {
		super(mensaje);
	}
}
