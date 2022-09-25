package com.jarzsoft.services.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFFinancialInfo;
import com.jarzsoft.entities.Foclaaso;
import com.jarzsoft.entities.Fotipcre;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.repository.FoclaasoRepository;
import com.jarzsoft.repository.FotipcreRepository;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;

@Component
public class WFStep_4Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final FotipcreRepository fotipcreRepository;

	private final FoclaasoRepository foclaasoRepository;

	private final ISolCreditoService solCreditoService;

	private final ISolCreditoMapper solCreditoMapper;

	private final IFilesUserService serviceFile;

	@Autowired
	public WFStep_4Service(IWWfMovService wWfMovService, FotipcreRepository fotipcreRepository,
			FoclaasoRepository foclaasoRepository, ISolCreditoService solCreditoService, IFilesUserService serviceFile,
			ISolCreditoMapper solCreditoMapper) {
		super();

		this.wWfMovService = wWfMovService;

		this.fotipcreRepository = fotipcreRepository;
		this.foclaasoRepository = foclaasoRepository;
		this.solCreditoService = solCreditoService;
		this.serviceFile = serviceFile;
		this.solCreditoMapper = solCreditoMapper;
	}

	@Override
	public DTOWF apply(DTOWF o, String user) {
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return calculateCapacity(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return createMove(o, user);
		}

		return o;
	}

	private DTOWF calculateCapacity(DTOWF o, String user) {

		BigDecimal capacidad = new BigDecimal("0");
		String entitie = o.getEntitie();
		Optional<Foclaaso> foclaaso = foclaasoRepository.findById(new BigInteger(entitie));
		if (null != foclaaso.get()) {
			BigDecimal valorRespeta = foclaaso.get().getValorRespeta();
			if (null != valorRespeta && valorRespeta.compareTo(new BigDecimal("0")) > 0) {
				capacidad = getTotalIngresos(o.getFinancial()).subtract(valorRespeta)
						.subtract(getTotalDescuentos(o.getFinancial()));
			} else {
				BigDecimal porcentajeRespeta = foclaaso.get().getPorcentajeRespeta();
				if (null != porcentajeRespeta && porcentajeRespeta.compareTo(new BigDecimal("0")) > 0) {
					BigDecimal totalIngresos = getTotalIngresos(o.getFinancial());
					capacidad = totalIngresos.subtract(totalIngresos.multiply(porcentajeRespeta))
							.subtract(getTotalDescuentos(o.getFinancial()));
				}
			}
		}

		BigDecimal valor1 = new BigDecimal("0");
		BigDecimal valor2 = new BigDecimal("0");
		BigDecimal valorCuotaEstimada = new BigDecimal("0");
		BigDecimal DesCuota = new BigDecimal("0");
		BigDecimal valorFuturo = new BigDecimal("0");
		BigDecimal valorDesembolso = new BigDecimal("0");
		BigDecimal CapacidadEndeudamiento = new BigDecimal("0");

		BigDecimal montoSolicitado = new BigDecimal(o.getValorPress());
		BigDecimal numCuotas = new BigDecimal(o.getNroCuotas());
		Fotipcre fotipcre = fotipcreRepository.findByCod("0" + entitie);

		valor1 = montoSolicitado.multiply(fotipcre.getRanInt1()).round(new MathContext(500, RoundingMode.HALF_UP));
		valor2 = montoSolicitado.divide(numCuotas, RoundingMode.HALF_UP);
		valorCuotaEstimada = valor1.add(valor2);
		DesCuota = valorCuotaEstimada.multiply(new BigDecimal(o.getPerCuota()));
		valorFuturo = DesCuota.multiply(numCuotas);
		List<Object[]> rangos = fotipcreRepository.findRangueByEntitie("0" + entitie, montoSolicitado);

		String rangoValue = String.valueOf(rangos.get(0));
		BigDecimal ran_valor = new BigDecimal(rangoValue);

		BigDecimal compra_cartera1 = o.getFinancial().getCompra_cartera1() != null
				? o.getFinancial().getCompra_cartera1()
				: new BigDecimal("0");

		BigDecimal compra_cartera2 = o.getFinancial().getCompra_cartera2() != null
				? o.getFinancial().getCompra_cartera2()
				: new BigDecimal("0");

		BigDecimal compra_cartera3 = o.getFinancial().getCompra_cartera3() != null
				? o.getFinancial().getCompra_cartera3()
				: new BigDecimal("0");

		BigDecimal compra_cartera4 = o.getFinancial().getCompra_cartera4() != null
				? o.getFinancial().getCompra_cartera4()
				: new BigDecimal("0");

		valorDesembolso = montoSolicitado.subtract(compra_cartera1).subtract(compra_cartera2).subtract(compra_cartera3)
				.subtract(compra_cartera4).subtract(ran_valor);
		CapacidadEndeudamiento = capacidad.subtract(valorDesembolso);

		o.getFinancial().setCapacidadEndeudamiento(CapacidadEndeudamiento.toString());
		o.getFinancial().setValorFuturo(valorFuturo.toString());
		return o;
	}

	private BigDecimal getTotalIngresos(DTOWFFinancialInfo info) {
		BigDecimal total = new BigDecimal("0");
		total = info.getSueldo().add(info.getBonificacion()).add(info.getBonos()).add(info.getCompensatorios())
				.add(info.getHoras_extras()).add(info.getOtros_pagos1()).add(info.getOtros_pagos2())
				.add(info.getOtros_pagos3()).add(info.getRecargos());
		return total;
	}

	private BigDecimal getTotalDescuentos(DTOWFFinancialInfo info) {
		BigDecimal total = new BigDecimal("0");
		total = info.getSalud().add(info.getPension()).add(info.getLibranza()).add(info.getCuota_sindical())
				.add(info.getCuota_interna()).add(info.getOtros_decuentos1()).add(info.getOtros_decuentos2())
				.add(info.getOtros_decuentos3()).add(info.getCompra_cartera1()).add(info.getEntidad_cartera1())
				.add(info.getObligacion_cartera1());
		return total;
	}

	private DTOWF createMove(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {

			String stateMov = EnumStates.TIPO_ESTADO.STATE_9.getName();
			String stateSol = EnumStates.TIPO_ESTADO.STATE_P.getName();
			if (new BigDecimal(o.getFinancial().getCapacidadEndeudamiento()).compareTo(new BigDecimal("0")) < 0) {
				stateMov = EnumStates.TIPO_ESTADO.STATE_8.getName();
				stateSol = EnumStates.TIPO_ESTADO.STATE_I.getName();
			}

			for (int i = 0; i < o.getFiles().size(); i++) {
				serviceFile.create(o.getNitter(), o.getNumeroRadicacion() + "", o.getFilesNames().get(i),
						o.getFiles().get(i));
			}

			credito.setEstado(stateSol);
			credito = solCreditoMapper.mapperDaoToDtoFinancial(o, credito);
			solCreditoService.create(credito);
			credito.setEstado(stateMov);
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_4.getName(),o.getIsUpdate());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_5.getName());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_4.getName();
	}

}
