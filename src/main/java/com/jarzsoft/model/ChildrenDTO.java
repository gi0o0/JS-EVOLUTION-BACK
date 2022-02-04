package com.jarzsoft.model;

public class ChildrenDTO {
	private String id;
	private String name;
	private String url;
	private String icon;

	public ChildrenDTO() {
		super();
	}

	public ChildrenDTO(String id, String name, String url, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}