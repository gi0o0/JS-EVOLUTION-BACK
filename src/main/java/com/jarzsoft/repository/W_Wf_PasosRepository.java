package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.entities.W_Wf_PasosPK;

@Repository
public interface W_Wf_PasosRepository extends JpaRepository<W_Wf_Pasos, W_Wf_PasosPK> {

	@Query(value = "SELECT id_wf,id_paso, LTRIM(RTRIM(nom_paso)) as nom_paso, LTRIM(RTRIM(email1)) as email1, LTRIM(RTRIM(email2)) as email2, LTRIM(RTRIM(email3)) as email3,sol_autoriza,sol_documentos,ord_paso,env_correo_paso,env_correo_autoriza,"
			+ " LTRIM(RTRIM(asunto_correo)) as asunto_correo,LTRIM(RTRIM(texto_correo)) as texto_correo,tiempo_alerta1,tiempo_alerta2,tiempo_alerta3,usu_ult_mod,fec_ult_mod,usu_crea,fec_crea FROM w_wf_pasos WHERE id_wf = :id order by ord_paso ASC ", nativeQuery = true)
	public List<W_Wf_Pasos> findByWf(@Param("id") String id);
	
	@Query(value = "SELECT  max (id_paso ) +1 FROM w_wf_pasos", nativeQuery = true)
	int getKey();

}
