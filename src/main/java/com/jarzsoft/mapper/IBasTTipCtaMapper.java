package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOBasTTipCta;
import com.jarzsoft.entities.Bas_T_Tip_Cta;

public interface IBasTTipCtaMapper {

	public List<DTOBasTTipCta> mapperList(List<Bas_T_Tip_Cta> list);

	public DTOBasTTipCta mapperEntitieToDto(Bas_T_Tip_Cta o);

}