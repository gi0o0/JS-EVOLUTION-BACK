package com.jarzsoft.services.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOReportDetalle;
import com.jarzsoft.service.IReportOnlineService;

@Service
public class ReportOnlineService implements IReportOnlineService {

	@Autowired
	public ReportOnlineService() {
		super();

	}

	public DTOReportDetalle createReportOnlineClient() {

		DTOReportDetalle archivoDetalleDto = new DTOReportDetalle();
	/*
	 * Map param = new HashMap<String, Object>(); param.put("numeroRadicacion",
	 * "12345");
	 * 
	 * Resource resource = new ClassPathResource(Constantes.REPORTE_CREDITO_SOL);
	 * InputStream input; try { input = resource.getInputStream(); byte[] bytes =
	 * JasperRunManager.runReportToPdf(input, param, new JREmptyDataSource());
	 * String nombreArchivo = "file.pdf"; archivoDetalleDto.setArchivo(bytes);
	 * archivoDetalleDto.setNombreArchivo(nombreArchivo);
	 * construirGuardarArchivo(123, nombreArchivo, bytes); } catch (IOException |
	 * JRException e) { e.printStackTrace(); }
	 */

		return archivoDetalleDto;
	}

	public void construirGuardarArchivo(int idSolicitud, String nombreArchivo, byte[] archivo) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("C:\\Agencias\\" + nombreArchivo);
			try {
				out.write(archivo);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
