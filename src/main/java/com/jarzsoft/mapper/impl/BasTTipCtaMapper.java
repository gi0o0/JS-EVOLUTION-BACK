package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOBasTTipCta;
import com.jarzsoft.entities.Bas_T_Tip_Cta;
import com.jarzsoft.mapper.IBasTTipCtaMapper;

@Service
public class BasTTipCtaMapper implements IBasTTipCtaMapper {

	@Override
	public List<DTOBasTTipCta> mapperList(List<Bas_T_Tip_Cta> list) {
		List<DTOBasTTipCta> response = new ArrayList<DTOBasTTipCta>();
		list.stream().forEach(o -> {
			response.add(new DTOBasTTipCta(o.getIdTipCta().toString(),
					null != o.getNomCta() ? o.getNomCta().trim() : ""));
		});

		return response;
	}

}
