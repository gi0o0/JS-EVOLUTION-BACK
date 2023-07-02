package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "w_wf_mov")
public class WWfMov implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_wf_mov")
	private Integer idWfMov;

	@Column(name = "id_wf")
	private Integer idWf;

	@Column(name = "nitter")
	private String nitTer;

	@Column(name = "id_paso")
	private String idPaso;

	@Column(name = "usu_movimiento")
	private String usuMovimiento;

	@Column(name = "numero_radicacion")
	private Integer numeroRadicacion;

	@Column(name = "est_paso")
	private String estPaso;

	@Column(name = "est_paso_mov")
	private String estPasoMov;

	@Column(name = "comentarios")
	private String comentarios;

	@Column(name = "env_correo")
	private String envCorreo;

	@Column(name = "adj_documentos")
	private String adjDocumentos;

	@Column(name = "en_espera")
	private String enEspera;

	@Column(name = "cie_sig_paso")
	private String cieSigPaso;

	@Column(name = "email1")
	private String email1;

	@Column(name = "email2")
	private String email2;

	@Column(name = "email3")
	private String email3;

	@Column(name = "email4")
	private String email4;

	@Column(name = "cifin")
	private String cifin;

	@Column(name = "res_cifin")
	private String resCifin;

	@Column(name = "datajuridico")
	private String datajuridico;

	@Column(name = "res_datajuridico")
	private String resDatajuridico;

	@Column(name = "fec_envio")
	private Date fecEnvio;

	@Column(name = "usu_comercial")
	private String usuComercial;

	@Column(name = "usu_comercial_vobo")
	private String usuComercialVobo;

	@Column(name = "usu_comercial_task")
	private String usuComercialTask;

	@Column(name = "usuario1")
	private String usuario1;

	@Column(name = "usuario1_vobo")
	private String usuario1Vobo;

	@Column(name = "usuario1_task")
	private String usuario1Task;

	@Column(name = "usuario2")
	private String usuario2;

	@Column(name = "usuario2_vobo")
	private String usuario2Vobo;

	@Column(name = "usuario2_task")
	private String usuario2Task;

	@Column(name = "usuario3")
	private String usuario3;

	@Column(name = "usuario3_vobo")
	private String usuario3Vobo;

	@Column(name = "usuario3_task")
	private String usuario3Task;

	@Column(name = "usuario4")
	private String usuario4;

	@Column(name = "usuario4_vobo")
	private String usuario4Vobo;

	@Column(name = "usuario4_task")
	private String usuario4Task;

	@Column(name = "codter")
	private String codTer;

	public WWfMov() {
	}

	@PrePersist
	public void prePersist() {
		this.cifin = "N";
		this.resCifin = " ";
		this.datajuridico = "N";
		this.resDatajuridico = " ";
		this.fecEnvio = new Date();
		this.usuComercialTask = "N";
		this.usuComercialVobo = "N";
		this.usuario1Vobo = "N";
		this.usuario1Task = "N";
		this.usuario2Vobo = "N";
		this.usuario2Task = "N";
		this.usuario3Vobo = "N";
		this.usuario3Task = "N";
		this.usuario4Vobo = "N";
		this.usuario4Task = "N";

		if (this.usuario1 == null) {
			this.usuario1 = "N";
		}
		if (this.usuario2 == null) {
			this.usuario2 = "N";
		}
		if (this.usuario3 == null) {
			this.usuario3 = "N";
		}
		if (this.usuario4 == null) {
			this.usuario4 = "N";
		}

	}

	@PreUpdate
	public void preUpdate() {
		this.cifin = "N";
		this.resCifin = " ";
		this.datajuridico = "N";
		this.resDatajuridico = " ";
		this.usuComercialTask = "N";
		this.usuComercialVobo = "N";
		this.usuario1Vobo = "N";
		this.usuario1Task = "N";
		this.usuario2Vobo = "N";
		this.usuario2Task = "N";
		this.usuario3Vobo = "N";
		this.usuario3Task = "N";
		this.usuario4Vobo = "N";
		this.usuario4Task = "N";

		if (this.usuario1 == null) {
			this.usuario1 = "N";
		}
		if (this.usuario2 == null) {
			this.usuario2 = "N";
		}
		if (this.usuario3 == null) {
			this.usuario3 = "N";
		}
		if (this.usuario4 == null) {
			this.usuario4 = "N";
		}
	}

	public Integer getIdWfMov() {
		return idWfMov;
	}

	public void setIdWfMov(Integer idWfMov) {
		this.idWfMov = idWfMov;
	}

	public Integer getIdWf() {
		return idWf;
	}

	public void setIdWf(Integer idWf) {
		this.idWf = idWf;
	}

	public String getUsuMovimiento() {
		return usuMovimiento;
	}

	public void setUsuMovimiento(String usuMovimiento) {
		this.usuMovimiento = usuMovimiento;
	}

	public Integer getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Integer numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public String getEstPaso() {
		return estPaso;
	}

	public void setEstPaso(String estPaso) {
		this.estPaso = estPaso;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEnvCorreo() {
		return envCorreo;
	}

	public void setEnvCorreo(String envCorreo) {
		this.envCorreo = envCorreo;
	}

	public String getAdjDocumentos() {
		return adjDocumentos;
	}

	public void setAdjDocumentos(String adjDocumentos) {
		this.adjDocumentos = adjDocumentos;
	}

	public String getEnEspera() {
		return enEspera;
	}

	public void setEnEspera(String enEspera) {
		this.enEspera = enEspera;
	}

	public String getCieSigPaso() {
		return cieSigPaso;
	}

	public void setCieSigPaso(String cieSigPaso) {
		this.cieSigPaso = cieSigPaso;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getEmail4() {
		return email4;
	}

	public void setEmail4(String email4) {
		this.email4 = email4;
	}

	public String getCifin() {
		return cifin;
	}

	public void setCifin(String cifin) {
		this.cifin = cifin;
	}

	public String getResCifin() {
		return resCifin;
	}

	public void setResCifin(String resCifin) {
		this.resCifin = resCifin;
	}

	public String getDatajuridico() {
		return datajuridico;
	}

	public void setDatajuridico(String datajuridico) {
		this.datajuridico = datajuridico;
	}

	public String getResDatajuridico() {
		return resDatajuridico;
	}

	public void setResDatajuridico(String resDatajuridico) {
		this.resDatajuridico = resDatajuridico;
	}

	public Date getFecEnvio() {
		return fecEnvio;
	}

	public void setFecEnvio(Date fecEnvio) {
		this.fecEnvio = fecEnvio;
	}

	public String getUsuComercial() {
		return usuComercial;
	}

	public void setUsuComercial(String usuComercial) {
		this.usuComercial = usuComercial;
	}

	public String getUsuComercialVobo() {
		return usuComercialVobo;
	}

	public void setUsuComercialVobo(String usuComercialVobo) {
		this.usuComercialVobo = usuComercialVobo;
	}

	public String getUsuComercialTask() {
		return usuComercialTask;
	}

	public void setUsuComercialTask(String usuComercialTask) {
		this.usuComercialTask = usuComercialTask;
	}

	public String getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(String usuario1) {
		this.usuario1 = usuario1;
	}

	public String getUsuario1Vobo() {
		return usuario1Vobo;
	}

	public void setUsuario1Vobo(String usuario1Vobo) {
		this.usuario1Vobo = usuario1Vobo;
	}

	public String getUsuario1Task() {
		return usuario1Task;
	}

	public void setUsuario1Task(String usuario1Task) {
		this.usuario1Task = usuario1Task;
	}

	public String getUsuario2() {
		return usuario2;
	}

	public void setUsuario2(String usuario2) {
		this.usuario2 = usuario2;
	}

	public String getUsuario2Vobo() {
		return usuario2Vobo;
	}

	public void setUsuario2Vobo(String usuario2Vobo) {
		this.usuario2Vobo = usuario2Vobo;
	}

	public String getUsuario2Task() {
		return usuario2Task;
	}

	public void setUsuario2Task(String usuario2Task) {
		this.usuario2Task = usuario2Task;
	}

	public String getUsuario3() {
		return usuario3;
	}

	public void setUsuario3(String usuario3) {
		this.usuario3 = usuario3;
	}

	public String getUsuario3Vobo() {
		return usuario3Vobo;
	}

	public void setUsuario3Vobo(String usuario3Vobo) {
		this.usuario3Vobo = usuario3Vobo;
	}

	public String getUsuario3Task() {
		return usuario3Task;
	}

	public void setUsuario3Task(String usuario3Task) {
		this.usuario3Task = usuario3Task;
	}

	public String getUsuario4() {
		return usuario4;
	}

	public void setUsuario4(String usuario4) {
		this.usuario4 = usuario4;
	}

	public String getUsuario4Vobo() {
		return usuario4Vobo;
	}

	public void setUsuario4Vobo(String usuario4Vobo) {
		this.usuario4Vobo = usuario4Vobo;
	}

	public String getUsuario4Task() {
		return usuario4Task;
	}

	public void setUsuario4Task(String usuario4Task) {
		this.usuario4Task = usuario4Task;
	}

	public String getCodTer() {
		return codTer;
	}

	public void setCodTer(String codTer) {
		this.codTer = codTer;
	}

	public String getIdPaso() {
		return idPaso;
	}

	public void setIdPaso(String idPaso) {
		this.idPaso = idPaso;
	}

	public String getEstPasoMov() {
		return estPasoMov;
	}

	public void setEstPasoMov(String estPasoMov) {
		this.estPasoMov = estPasoMov;
	}

	public String getNitTer() {
		return nitTer;
	}

	public void setNitTer(String nitTer) {
		this.nitTer = nitTer;
	}

}
