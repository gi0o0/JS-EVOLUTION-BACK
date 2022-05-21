package com.jarzsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOReportDetalle;
import com.jarzsoft.service.IReportOnlineService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_REPORTONLINE)
public class ReportOnlineController {

	private final IReportOnlineService reportOnlineService;

	@Autowired
	public ReportOnlineController(IReportOnlineService reportOnlineService) {
		super();
		this.reportOnlineService = reportOnlineService;

	}

	@GetMapping(value = "/archivo", produces = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Resource> generarArchivoDetalle() {
		DTOReportDetalle archivoDetalleDto = reportOnlineService.createReportOnlineClient();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + archivoDetalleDto.getNombreArchivo() + "\"")
				.body(new ByteArrayResource(archivoDetalleDto.getArchivo()));

	}

}
