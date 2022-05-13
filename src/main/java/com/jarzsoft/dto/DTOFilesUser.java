package com.jarzsoft.dto;

public class DTOFilesUser {

	private String name;
	private String encode;
	private String user;
	private String request;
	private String idDoc;

	public DTOFilesUser() {
		super();
	}

	public DTOFilesUser(String name, String encode, String user, String request, String idDoc) {
		super();
		this.name = name;
		this.encode = encode;
		this.user = user;
		this.request = request;
		this.idDoc = idDoc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}

}
