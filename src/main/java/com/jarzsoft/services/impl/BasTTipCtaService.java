package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOBasTTipCta;
import com.jarzsoft.mapper.IBasTTipCtaMapper;
import com.jarzsoft.repository.Bas_T_Tip_CtaRepository;
import com.jarzsoft.service.IBasTTipCtaService;

@Service
public class BasTTipCtaService implements IBasTTipCtaService {

	private final Bas_T_Tip_CtaRepository bas_T_Tip_CtaRepository;

	private final IBasTTipCtaMapper bas_T_Tip_CtaMapper;

	@Autowired
	public BasTTipCtaService(Bas_T_Tip_CtaRepository bas_T_Tip_CtaRepository,
			IBasTTipCtaMapper bas_T_Tip_CtaMapper) {
		super();
		this.bas_T_Tip_CtaRepository = bas_T_Tip_CtaRepository;
		this.bas_T_Tip_CtaMapper = bas_T_Tip_CtaMapper;

	}

	@Override
	public List<DTOBasTTipCta> getAll() {
		return bas_T_Tip_CtaMapper.mapperList(bas_T_Tip_CtaRepository.findAll());
	}

}
