package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.entities.W_Wf_Prestamo;
import com.jarzsoft.entities.W_Wf_PrestamoPK;
import com.jarzsoft.mapper.IWWfPrestamoMapper;
import com.jarzsoft.util.Comunes;

@Service
public class WWfPrestamoMapper implements IWWfPrestamoMapper {

	@Override
	public W_Wf_Prestamo mapperDtoToEntitie(DTOWFPrestamos o) {

		W_Wf_PrestamoPK outPk = new W_Wf_PrestamoPK();
		outPk.setIdWf(o.getIdWf());
		outPk.setNumeroRadicacion(o.getNumeroRadicacion());
		outPk.setNumeroCredito(o.getNumeroCredito());

		W_Wf_Prestamo out = new W_Wf_Prestamo();
		out.setClaAsoci(o.getClaAsoci());
		out.setIndCer(o.getIndCer());
		out.setIndCerDeu(o.getIndCerDeu());
		out.setIndDp(o.getIndDp());
		out.setIndEst(o.getIndEst());
		out.setIndPaz(o.getIndPaz());
		out.setW_Wf_PrestamoPK(outPk);

		return out;
	}

	@Override
	public DTOWFPrestamos mapperEntitieToDao(W_Wf_Prestamo o) {

		DTOWFPrestamos out = new DTOWFPrestamos();
		out.setClaAsoci(o.getClaAsoci());
		out.setIndCer(o.getIndCer());
		out.setIndCerDeu(o.getIndCerDeu());
		out.setIndDp(o.getIndDp());
		out.setIndEst(o.getIndEst());
		out.setIndPaz(o.getIndPaz());
		out.setIdWf(o.getW_Wf_PrestamoPK().getIdWf());
		out.setNumeroRadicacion(o.getW_Wf_PrestamoPK().getNumeroRadicacion());
		out.setNumeroCredito(o.getW_Wf_PrestamoPK().getNumeroCredito());

		return out;
	}

	@Override
	public DTOWFPrestamos mapperEntitieWfToDao(DTOWFPqr o, String numCredito) {
		DTOWFPrestamos out = new DTOWFPrestamos();
		out.setClaAsoci(o.getEntitie());
		out.setIndCer(Comunes.stateDocs(o.getCertificado()));
		out.setIndCerDeu(Comunes.stateDocs(o.getCertificadoDeuda()));
		out.setIndDp(Comunes.stateDocs(o.getDerechoPeticion()));
		out.setIndEst(Comunes.stateDocs(o.getEstadoCuenta()));
		out.setIndPaz(Comunes.stateDocs(o.getPazSalvo()));
		out.setIdWf(Long.parseLong(o.getIdWf()));
		out.setNumeroRadicacion(o.getNumeroRadicacion().longValue());
		out.setNumeroCredito(Long.parseLong(numCredito.toString()));

		return out;
	}

	@Override
	public List<DTOWFPrestamos> mapperListEntitieToListDao(List<Object[]> o) {

		List<DTOWFPrestamos> response = new ArrayList<DTOWFPrestamos>();
		o.stream().forEach(obj -> {
			response.add(new DTOWFPrestamos(Long.parseLong(obj[0].toString().trim()), ((Double) obj[1]).longValue(),
					Long.parseLong(obj[2].toString().trim()), String.valueOf(obj[3]), String.valueOf(obj[4]),
					String.valueOf(obj[5]), String.valueOf(obj[6]), String.valueOf(obj[7]), String.valueOf(obj[8])));
		});

		return response;
	}

}
