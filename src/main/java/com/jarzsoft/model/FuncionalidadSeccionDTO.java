package com.jarzsoft.model;

import java.util.List;

public class FuncionalidadSeccionDTO {

	private String id;
	private String name;
	private String icon;
	private String url;
	private List<ChildrenDTO> children;

	public FuncionalidadSeccionDTO() {
		super();
	}

	public FuncionalidadSeccionDTO(String id, String name, String url, String icon) {
		super();
		this.name = name;
		this.id = id;
		this.url = url;
		this.icon = icon;

	}

	public FuncionalidadSeccionDTO(String name, String id, List<ChildrenDTO> secciones) {
		super();
		this.name = name;
		this.id = id;
		this.children = secciones;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ChildrenDTO> getChildren() {
		return children;
	}

	public void setChildren(List<ChildrenDTO> children) {
		this.children = children;
	}

}