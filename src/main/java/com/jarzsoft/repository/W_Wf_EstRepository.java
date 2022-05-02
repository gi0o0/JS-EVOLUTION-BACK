package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf_Est;
import com.jarzsoft.entities.W_Wf_EstPK;

@Repository
public interface W_Wf_EstRepository extends JpaRepository<W_Wf_Est, W_Wf_EstPK> {

	@Query(value = "SELECT id_wf,id_estado, LTRIM(RTRIM(nom_estado)) as nom_estado, LTRIM(RTRIM(ind_inicio)) as ind_inicio, LTRIM(RTRIM(ind_Final)) as ind_Final, ord_estado,"
			+ "usu_ult_mod,fec_ult_mod,usu_crea,fec_crea FROM w_wf_est WHERE id_wf = :id order by id_estado ASC ", nativeQuery = true)
	public List<W_Wf_Est> findByWf(@Param("id") String id);

	@Query(value = "SELECT CASE WHEN max(id_estado) IS NULL THEN 1 ELSE max (id_estado)+1 END FROM w_wf_est", nativeQuery = true)
	int getKey();

}
