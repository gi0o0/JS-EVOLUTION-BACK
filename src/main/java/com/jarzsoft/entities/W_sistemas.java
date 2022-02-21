package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "web.w_sistemas")
public class W_sistemas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_sistema")
	private Integer numero_sistema;

	@Column(name = "nombre_sistema")
	private String nombre_sistema;

	public W_sistemas() {
	}

	public W_sistemas(Integer numero_sistema, String nombre_sistema) {
		super();
		this.numero_sistema = numero_sistema;
		this.nombre_sistema = nombre_sistema;
	}

	public Integer getNumero_sistema() {
		return numero_sistema;
	}

	public void setNumero_sistema(Integer numero_sistema) {
		this.numero_sistema = numero_sistema;
	}

	public String getNombre_sistema() {
		return nombre_sistema;
	}

	public void setNombre_sistema(String nombre_sistema) {
		this.nombre_sistema = nombre_sistema;
	}

}
