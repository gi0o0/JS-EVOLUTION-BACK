package com.jarzsoft.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOReportDetalle;
import com.jarzsoft.mapper.ISystemMapper;
import com.jarzsoft.repository.W_Bas_T_Per_OpcionRepository;
import com.jarzsoft.repository.W_Men_OpcionRepository;
import com.jarzsoft.repository.W_SistemasRepository;
import com.jarzsoft.service.IReportOnlineService;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Constantes;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class ReportOnlineService implements IReportOnlineService {

	private final W_SistemasRepository dao;

	private final W_Bas_T_Per_OpcionRepository w_Bas_T_Per_Opcion;

	private final ISystemMapper mapper;

	private final W_Men_OpcionRepository opcionRepository;

	private final IUserService usuarioService;

	@Autowired
	public ReportOnlineService(W_SistemasRepository dao, ISystemMapper mapper, W_Men_OpcionRepository opcionRepository,
			IUserService usuarioService, W_Bas_T_Per_OpcionRepository w_Bas_T_Per_Opcion) {
		super();
		this.dao = dao;
		this.mapper = mapper;
		this.opcionRepository = opcionRepository;
		this.usuarioService = usuarioService;
		this.w_Bas_T_Per_Opcion = w_Bas_T_Per_Opcion;

	}

	public DTOReportDetalle createReportOnlineClient() {

		DTOReportDetalle archivoDetalleDto = new DTOReportDetalle();
		Map param = new HashMap<String, Object>();
		param.put(Constantes.PA_MUT_CIUU, false);
		param.put(Constantes.PA_MUT_DBASIC, false);
		param.put(Constantes.PA_MUT_NOM, false);
		param.put(Constantes.PA_MUT_INFO_HEADER, "213");
		param.put(Constantes.PA_NOMBRE_SOLI, "23");
		param.put(Constantes.PA_TIPOIDENT, "dsf");
		param.put(Constantes.PA_MATRI, "12");
		param.put(Constantes.PA_TEXT_FOOTER, "footer");
		param.put(Constantes.PA_REGISTRO, "header");
		param.put(Constantes.PA_MUT_NOM, true);
		param.put(Constantes.PA_MUT_NOM_TITU, "sds");
		param.put(Constantes.PA_MUT_NOM_TEXT, "dfdsf");
		param.put(Constantes.PA_MUT_CIUU_TIP, "");
		param.put(Constantes.PA_MUT_CIUU_TIP2, "");
		param.put(Constantes.PA_MUT_CIUU_TIP3, "");
		param.put(Constantes.PA_MUT_CIUU_TIP4, "");

		Resource resource = new ClassPathResource(Constantes.TIPO_REPORTE);
		InputStream input;
		try {
			input = resource.getInputStream();
			byte[] bytes = JasperRunManager.runReportToPdf(input, param, new JREmptyDataSource());
			String nombreArchivo = "file.pdf";
			archivoDetalleDto.setArchivo(bytes);
			archivoDetalleDto.setNombreArchivo(nombreArchivo);
			construirGuardarArchivo(123, nombreArchivo, bytes);
		} catch (IOException | JRException e) {
			e.printStackTrace();
		}


		return archivoDetalleDto;
	}

	public void construirGuardarArchivo(int idSolicitud, String nombreArchivo, byte[] archivo) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("C:\\Agencias\\"+ nombreArchivo);
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
