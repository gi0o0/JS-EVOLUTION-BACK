package com.jarzsoft.services.impl;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.entities.Cfi_t_sanciones;
import com.jarzsoft.entities.Terceros;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.repository.Cfi_t_sancionesRepository;
import com.jarzsoft.repository.TercerosRepository;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.util.Constantes;

@Service
public class TercerosService implements ITercerosService {

	private final TercerosRepository tercerosRepository;
	private final ITercerosMapper mapper;
	private final Cfi_t_sancionesRepository sancionesRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public TercerosService(TercerosRepository tercerosRepository, ITercerosMapper mapper,
			Cfi_t_sancionesRepository sancionesRepository) {
		super();
		this.tercerosRepository = tercerosRepository;
		this.mapper = mapper;
		this.sancionesRepository = sancionesRepository;
	}

	@Override
	public DTOTerceros create(DTOTerceros o, String user, boolean isCodeo) {
		Terceros externalUser = findTerByNiter(o.getNitTer());

		if (externalUser == null) {
			o.setCodTer(new BigDecimal(tercerosRepository.getKey() + ""));
		} else {

			List<Cfi_t_sanciones> sancionesUser = sancionesRepository.getUserSanciones(externalUser.getCodTer() + "");
			if (sancionesUser.size() > 0)
				throw new PageNoFoundException(Constantes.MESSAGE_USER_WITH_SANCTION + " " + o.getNitTer());

			o.setCodTer(externalUser.getCodTer());
			if(isCodeo) { //ADD FIELDS CODEO
				o.setTelter(externalUser.getTelter());
				o.setTelter1(externalUser.getTelter1());
				o.setTelter2(externalUser.getTelter2());
				o.setEntBan(externalUser.getEntBan());
				o.setNumCta(externalUser.getNumCta());
				o.setTipCta(externalUser.getTipCta());				
			}

		}

		externalUser = tercerosRepository.save(mapper.mapperDtoToEntitie(o));

		return mapper.mapperEntitieToDao(externalUser);
	}

	@Override
	public DTOTerceros findByNiter(String nitTer) {
		return mapper.mapperEntitieToDao(findTerByNiter(nitTer));
	}

	private Terceros findTerByNiter(String nitTer) {
		return tercerosRepository.findByNiter(nitTer);
	}

	@Override
	public DTOTerceros findByCodter(String codTer) {
		return mapper.mapperEntitieToDao(tercerosRepository.findByCodter(codTer));
	}

	@Override
	public List<DTOTerceros> getAsesores() {
		return mapper.mapperList(tercerosRepository.getAsesores());
	}

	@Override
	public String modificarClaveLink(String nitTer, String hash) {
		tercerosRepository.modificarClaveLink(nitTer, hash);
		return hash;
	}

	@Override
	public DTOTerceros findByHash(String hash) {
		return mapper.mapperEntitieToDao(tercerosRepository.findByHash(hash));
	}

	@Override
	public DTOTerceros findByNiterAndSchema(String scheme, String nitTer) {
		DTOTerceros out = null;
		Query queryScheme = entityManager
				.createNativeQuery(TercerosRepository.findTerceroByNitterAndScheme(scheme, nitTer));
		try {
			BigDecimal codTer = (BigDecimal) queryScheme.getSingleResult();
			out = new DTOTerceros();
			out.setCodTer(codTer);
		} catch (Exception e) {
			return out;
		}

		return out;
	}

}
