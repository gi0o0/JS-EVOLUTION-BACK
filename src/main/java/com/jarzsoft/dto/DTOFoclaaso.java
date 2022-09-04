package com.jarzsoft.dto;

import java.util.Date;

public class DTOFoclaaso {

	private String id;
	private String name;

	private Long monto1;
	private Long monto2;
	private Long monto3;
	private Long monto4;

	private String indCodeudorMonto1;
	private String indCodeudorMonto2;
	private String indCodeudorMonto3;
	private String indCodeudorMonto4;

	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOFoclaaso() {
		super();
	}



	public DTOFoclaaso(String id, String name, Long monto1, Long monto2, Long monto3, Long monto4,
			String indCodeudorMonto1, String indCodeudorMonto2, String indCodeudorMonto3, String indCodeudorMonto4,
			String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea) {
		super();
		this.id = id;
		this.name = name;
		this.monto1 = monto1;
		this.monto2 = monto2;
		this.monto3 = monto3;
		this.monto4 = monto4;
		this.indCodeudorMonto1 = indCodeudorMonto1;
		this.indCodeudorMonto2 = indCodeudorMonto2;
		this.indCodeudorMonto3 = indCodeudorMonto3;
		this.indCodeudorMonto4 = indCodeudorMonto4;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMonto1() {
		return monto1;
	}

	public void setMonto1(Long monto1) {
		this.monto1 = monto1;
	}

	public Long getMonto2() {
		return monto2;
	}

	public void setMonto2(Long monto2) {
		this.monto2 = monto2;
	}

	public Long getMonto3() {
		return monto3;
	}

	public void setMonto3(Long monto3) {
		this.monto3 = monto3;
	}

	public Long getMonto4() {
		return monto4;
	}

	public void setMonto4(Long monto4) {
		this.monto4 = monto4;
	}

	public String getUsuUltMod() {
		return usuUltMod;
	}

	public void setUsuUltMod(String usuUltMod) {
		this.usuUltMod = usuUltMod;
	}

	public Date getFecUltMod() {
		return fecUltMod;
	}

	public void setFecUltMod(Date fecUltMod) {
		this.fecUltMod = fecUltMod;
	}

	public Date getFecCrea() {
		return fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public String getUsuCrea() {
		return usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	public String getIndCodeudorMonto1() {
		return indCodeudorMonto1;
	}

	public void setIndCodeudorMonto1(String indCodeudorMonto1) {
		this.indCodeudorMonto1 = indCodeudorMonto1;
	}

	public String getIndCodeudorMonto2() {
		return indCodeudorMonto2;
	}

	public void setIndCodeudorMonto2(String indCodeudorMonto2) {
		this.indCodeudorMonto2 = indCodeudorMonto2;
	}

	public String getIndCodeudorMonto3() {
		return indCodeudorMonto3;
	}

	public void setIndCodeudorMonto3(String indCodeudorMonto3) {
		this.indCodeudorMonto3 = indCodeudorMonto3;
	}

	public String getIndCodeudorMonto4() {
		return indCodeudorMonto4;
	}

	public void setIndCodeudorMonto4(String indCodeudorMonto4) {
		this.indCodeudorMonto4 = indCodeudorMonto4;
	}

	
	
}
