package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf_Pas_Doc;
import com.jarzsoft.entities.W_Wf_Pas_DocPK;

@Repository
public interface W_Wf_Pas_DocRepository extends JpaRepository<W_Wf_Pas_Doc, W_Wf_Pas_DocPK> {

	@Query(value = "SELECT id_wf,id_paso,id_documento, LTRIM(RTRIM(nom_documento)) as nom_documento, LTRIM(RTRIM(env_rec)) as env_rec,"
			+ "usu_ult_mod,fec_ult_mod,usu_crea,fec_crea,Ind_obligatorio FROM w_wf_pas_doc WHERE id_wf = :id AND id_paso = :idStep order by id_documento ASC ", nativeQuery = true)
	public List<W_Wf_Pas_Doc> findByWfAndStep(@Param("id") String id, @Param("idStep") String idStep);

	@Query(value = "SELECT CASE WHEN max(id_documento) IS NULL THEN 1 ELSE  max (id_documento )+1 END FROM w_wf_pas_doc", nativeQuery = true)
	int getKey();

}
