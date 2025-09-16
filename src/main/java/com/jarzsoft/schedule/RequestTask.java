package com.jarzsoft.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jarzsoft.entities.Parametro;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.repository.SolCreditoRepository;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumStates;

@Component
public class RequestTask {

	private final ParametroRepository parametroRepository;

	private final SolCreditoRepository solCreditoRepository;

	private static final Logger LOGGER = LogManager.getLogger(RequestTask.class);

	public RequestTask(ParametroRepository parametroRepository, SolCreditoRepository solCreditoRepository) {
		super();
		this.parametroRepository = parametroRepository;
		this.solCreditoRepository = solCreditoRepository;

	}

	@Scheduled(cron = "${task.cron.request-state}", zone = "${task.cron.zone}")
	public synchronized void ejecutarTarea() {

		LOGGER.info("==== Inicio de la tarea programada: actualizar estados de SOL_CREDITO ====");

		try {
			Parametro param = parametroRepository.findByParamIdAndParamtext(Constantes.ADMIN_SOLICITUD,
					Constantes.DIAS_EXPIRACION_SOLI);

			int diasExpiracion = Integer.parseInt(param.getValue().trim());
			LOGGER.info("Valor del parámetro Dias Expiración: " + diasExpiracion);

			solCreditoRepository.modificarEstadoExDias(EnumStates.TIPO_ESTADO.STATE_C.getName(), diasExpiracion);

			LOGGER.info("Tarea finalizada correctamente. ");
		} catch (Exception e) {
			LOGGER.info("Error ejecutando la tarea programada: " + e);
		}

		LOGGER.info("==== Fin de la tarea programada ====");
	}

}
