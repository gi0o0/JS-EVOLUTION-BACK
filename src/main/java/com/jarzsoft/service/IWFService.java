package com.jarzsoft.service;

import com.jarzsoft.dto.DTOWF;

public interface IWFService {

	DTOWF create(DTOWF o, String user);

	DTOWF getById(Integer id);

}
