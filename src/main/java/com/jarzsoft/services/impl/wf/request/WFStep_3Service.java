package com.jarzsoft.services.impl.wf.request;

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
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.entities.Foclaaso;
import com.jarzsoft.entities.Fotipcre;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.repository.FoclaasoRepository;
import com.jarzsoft.repository.FotipcreRepository;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;
import com.jarzsoft.util.EnumWF;

@Component
public class WFStep_3Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final FotipcreRepository fotipcreRepository;

	private final FoclaasoRepository foclaasoRepository;

	private final ISolCreditoService solCreditoService;

	private final ISolCreditoMapper solCreditoMapper;

	private final IFilesUserService serviceFile;

	private final IWFParameterService wFParameterService;

	@Autowired
	public WFStep_3Service(IWWfMovService wWfMovService, FotipcreRepository fotipcreRepository,
			FoclaasoRepository foclaasoRepository, ISolCreditoService solCreditoService, IFilesUserService serviceFile,
			ISolCreditoMapper solCreditoMapper, IWFParameterService wFParameterService) {
		super();

		this.wWfMovService = wWfMovService;

		this.fotipcreRepository = fotipcreRepository;
		this.foclaasoRepository = foclaasoRepository;
		this.solCreditoService = solCreditoService;
		this.serviceFile = serviceFile;
		this.solCreditoMapper = solCreditoMapper;
		this.wFParameterService = wFParameterService;
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
		o.setFinancial(validateFinancialInfo(o.getFinancial()));

		capacidad = getTotalIngresos(o.getFinancial()).subtract(getTotalDescuentos(o.getFinancial()));
		String entitie = o.getEntitie();
		Optional<Foclaaso> foclaaso = foclaasoRepository.findById(new BigInteger(entitie));
		if (null != foclaaso.get()) {
			BigDecimal valorRespeta = foclaaso.get().getValorRespeta();
			if (null != valorRespeta && valorRespeta.compareTo(new BigDecimal("0")) > 0) {
				capacidad = capacidad.subtract(valorRespeta);
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
		BigDecimal valorPor = new BigDecimal("0");
		BigDecimal ranIntPor = new BigDecimal("0");

		BigDecimal valorCuotaEstimada = new BigDecimal("0");
		BigDecimal DesCuota = new BigDecimal("0");
		BigDecimal valorFuturo = new BigDecimal("0");
		BigDecimal valorDesembolso = new BigDecimal("0");
		BigDecimal CapacidadEndeudamiento = new BigDecimal("0");

		BigDecimal montoSolicitado = new BigDecimal(o.getValorPress());
		BigDecimal numCuotas = new BigDecimal(o.getNroCuotas());

		BigDecimal ranInt1 = new BigDecimal("0");
		Fotipcre fotipcre = fotipcreRepository.findByCod(o.getFoticrep());
		if (null != fotipcre) {
			ranInt1 = fotipcre.getRanInt1().divide(new BigDecimal("100"));
		}

		valor1 = montoSolicitado.multiply(ranInt1).round(new MathContext(500, RoundingMode.HALF_UP));
		valor2 = montoSolicitado.divide(numCuotas, RoundingMode.HALF_UP);
		valorCuotaEstimada = valor1.add(valor2);// Valor cuota
		DesCuota = valorCuotaEstimada.multiply(new BigDecimal(o.getPerCuota()));
		valorFuturo = DesCuota.multiply(numCuotas);
		List<Object[]> rangos = fotipcreRepository.findRangueByEntitie(o.getFoticrep(), montoSolicitado);

		List<Object[]> rangosP = fotipcreRepository.findRangueByEntitieP(o.getFoticrep(), montoSolicitado);

		String rangoValue = "0";
		if (rangos.size() > 0) {
			rangoValue = String.valueOf(rangos.get(0));
			ranIntPor = (new BigDecimal(String.valueOf(rangosP.get(0)))).divide(new BigDecimal("100"));
			valorPor = montoSolicitado.multiply(ranIntPor).round(new MathContext(500, RoundingMode.HALF_UP));
		}

		BigDecimal ran_valor = new BigDecimal(rangoValue);

		BigDecimal compra_cartera1 = Comunes.validIsNullNumberEmpty(o.getFinancial().getCompra_cartera1());

		BigDecimal compra_cartera2 = Comunes.validIsNullNumberEmpty(o.getFinancial().getCompra_cartera2());

		BigDecimal compra_cartera3 = Comunes.validIsNullNumberEmpty(o.getFinancial().getCompra_cartera3());

		BigDecimal compra_cartera4 = Comunes.validIsNullNumberEmpty(o.getFinancial().getCompra_cartera4());

		valorDesembolso = montoSolicitado.subtract(compra_cartera1).subtract(compra_cartera2).subtract(compra_cartera3)
				.subtract(compra_cartera4).subtract(ran_valor).subtract(valorPor);
		CapacidadEndeudamiento = capacidad.subtract(DesCuota);

		o.getFinancial().setCapacidadEndeudamiento(CapacidadEndeudamiento.toString());
		o.getFinancial().setValorFuturo(valorFuturo.toString());
		o.getFinancial().setValorCuotaEstimada(valorCuotaEstimada.toString());
		o.getFinancial().setDisponible(capacidad.toString());
		o.getFinancial().setValorDesembolso(valorDesembolso.toString());
		o.setTasaInt(ranInt1.toString());
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
				.add(info.getOtros_decuentos3());
		return total;
	}

	private DTOWFFinancialInfo validateFinancialInfo(DTOWFFinancialInfo info) {

		BigDecimal ValueDefault = new BigDecimal("0");
		info.setSueldo(info.getSueldo() != null ? info.getSueldo() : ValueDefault);
		info.setRecargos(info.getRecargos() != null ? info.getRecargos() : ValueDefault);
		info.setBonos(info.getBonos() != null ? info.getBonos() : ValueDefault);
		info.setCompensatorios(info.getCompensatorios() != null ? info.getCompensatorios() : ValueDefault);
		info.setBonificacion(info.getBonificacion() != null ? info.getBonificacion() : ValueDefault);
		info.setHoras_extras(info.getHoras_extras() != null ? info.getHoras_extras() : ValueDefault);
		info.setOtros_pagos1(info.getOtros_pagos1() != null ? info.getOtros_pagos1() : ValueDefault);
		info.setOtros_pagos2(info.getOtros_pagos2() != null ? info.getOtros_pagos2() : ValueDefault);
		info.setOtros_pagos3(info.getOtros_pagos3() != null ? info.getOtros_pagos3() : ValueDefault);
		info.setSalud(info.getSalud() != null ? info.getSalud() : ValueDefault);
		info.setPension(info.getPension() != null ? info.getPension() : ValueDefault);
		info.setLibranza(info.getLibranza() != null ? info.getLibranza() : ValueDefault);
		info.setCuota_sindical(info.getCuota_sindical() != null ? info.getCuota_sindical() : ValueDefault);
		info.setCuota_interna(info.getCuota_interna() != null ? info.getCuota_interna() : ValueDefault);
		info.setOtros_decuentos1(info.getOtros_decuentos1() != null ? info.getOtros_decuentos1() : ValueDefault);
		info.setOtros_decuentos2(info.getOtros_decuentos2() != null ? info.getOtros_decuentos2() : ValueDefault);
		info.setOtros_decuentos3(info.getOtros_decuentos3() != null ? info.getOtros_decuentos3() : ValueDefault);
		info.setCompra_cartera1(info.getCompra_cartera1() != null ? info.getCompra_cartera1() : ValueDefault + "");
		info.setCompra_cartera2(info.getCompra_cartera2() != null ? info.getCompra_cartera2() : ValueDefault + "");
		info.setCompra_cartera3(info.getCompra_cartera3() != null ? info.getCompra_cartera3() : ValueDefault + "");
		info.setCompra_cartera4(info.getCompra_cartera4() != null ? info.getCompra_cartera4() : ValueDefault + "");

		return info;
	}

	private DTOWF createMove(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {

			String stateMov = EnumStates.TIPO_ESTADO.STATE_9.getName();
			String stateSol = EnumStates.TIPO_ESTADO.STATE_S.getName();

			List<DTOWalletUser> getPortafolio = wFParameterService.getPortafolio(o.getCodTer());
			Optional<Object> isWallet = getPortafolio.stream()
					.filter(c -> c.getEstCredito().equals(EnumStates.TIPO_ESTADO.STATE_C.getName())
							|| c.getEstCredito().equals(EnumStates.TIPO_ESTADO.STATE_P.getName()))
					.findFirst().map(c -> true);

			if (isWallet.isPresent()) {
				if ((Boolean) isWallet.get()) {
					stateMov = EnumStates.TIPO_ESTADO.STATE_8.getName();
					stateSol = EnumStates.TIPO_ESTADO.STATE_I.getName();
				}
			}

			if (new BigDecimal(o.getFinancial().getCapacidadEndeudamiento()).compareTo(new BigDecimal("0")) < 0) {
				stateMov = EnumStates.TIPO_ESTADO.STATE_8.getName();
				stateSol = EnumStates.TIPO_ESTADO.STATE_I.getName();

				throw new PageNoFoundException(
						"No cumple con la  Capacidad Endeudamiento -> " + o.getFinancial().getCapacidadEndeudamiento());
			}

			if (null != o.getFiles()) {
				for (int i = 0; i < o.getFiles().size(); i++) {
					serviceFile.create(o.getIdWf() + o.getNumeroRadicacion() + "", getType(), o.getNitter(),
							o.getFiles().get(i));
				}
			}

			WWfMov mov = wWfMovService.findMovByNumRad(o.getNumeroRadicacion(), EnumWF.TIPO_WF.IDWF_4.getName(),
					EnumSteps.TIPO_PASO.STEP_3.getName());
			if (null != mov && o.getIsUpdate() && !credito.getEstado().equals(EnumStates.TIPO_ESTADO.STATE_I.getName()))
				stateSol = credito.getEstado();

			credito.setEstado(stateSol);
			credito = solCreditoMapper.mapperDaoToDtoFinancial(o, credito);
			credito.setTasaInt(o.getTasaInt());
			solCreditoService.create(credito);

			credito.setEstado(stateMov);
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_3.getName(), o.getIsUpdate(),
					o.getIdWf());

			o.setNextStep(EnumSteps.TIPO_PASO.STEP_4.getName());
			if (stateSol.equals(EnumStates.TIPO_ESTADO.STATE_I.getName()))
				o.setNextStep(EnumSteps.TIPO_PASO.STEP_I.getName());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_3.getName();
	}

}