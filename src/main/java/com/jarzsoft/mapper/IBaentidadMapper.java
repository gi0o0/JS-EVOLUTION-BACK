package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOBaentidad;
import com.jarzsoft.entities.Baentida;

public interface IBaentidadMapper {

	public List<DTOBaentidad> mapperList(List<Baentida> list);

	public DTOBaentidad mapperEntitieToDto(Baentida o);

}