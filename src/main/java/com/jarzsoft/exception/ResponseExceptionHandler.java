package com.jarzsoft.exception;

import java.util.Date;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jarzsoft.dto.LogArchivoDTO;
import com.jarzsoft.util.EnumUtils;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LogManager.getLogger(ResponseExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request) {

		if (ex instanceof TransactionSystemException) {
			System.out.println(ex.getMessage());
		}

		// se valida el tipo de exception con if .. se presenta el mensaje.
		logger.error(new LogArchivoDTO(request.getDescription(true), EnumUtils.TIPO_TRAZABILIDAD.ERROR + "",
				ex.getMessage(), "", "", "", "").toString());
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(true));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(ModeloNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error(new LogArchivoDTO(request.getDescription(true), EnumUtils.TIPO_TRAZABILIDAD.ERROR + "",
				ex.getMessage(), "", "", "", "").toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PageNoFoundException.class)
	public final ResponseEntity<Object> manejarPageNofoundExcepciones(PageNoFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error(new LogArchivoDTO(request.getDescription(true), EnumUtils.TIPO_TRAZABILIDAD.ERROR + "",
				ex.getMessage(), "", "", "", "").toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ForbiddenException.class)
	public final ResponseEntity<Object> manejarForbiddenExceptions(ForbiddenException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error(new LogArchivoDTO(request.getDescription(true), EnumUtils.TIPO_TRAZABILIDAD.ERROR + "",
				ex.getMessage(), "", "", "", "").toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public final ResponseEntity<Object> manejarUnauthorizedExceptions(UnauthorizedException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		logger.error(new LogArchivoDTO(request.getDescription(true), EnumUtils.TIPO_TRAZABILIDAD.ERROR + "",
				ex.getMessage(), "", "", "", "").toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}

}
