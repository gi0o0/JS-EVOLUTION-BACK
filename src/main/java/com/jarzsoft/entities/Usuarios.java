package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size(max = 10)
	@Column(name = "usuario")
	private String usuario;

	@Size(max = 40)
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "codter")
	private BigDecimal codTer;

	public Usuarios() {
	}

	public Usuarios(@Size(max = 10) String usuario, @Size(max = 40) String nombre,
			BigDecimal codTer) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.codTer = codTer;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getCodTer() {
		return codTer;
	}

	public void setCodTer(BigDecimal codTer) {
		this.codTer = codTer;
	}

}
