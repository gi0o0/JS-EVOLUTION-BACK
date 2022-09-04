package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf_Pas_Aut;
import com.jarzsoft.entities.W_Wf_Pas_AutPK;

@Repository
public interface W_Wf_Pas_AutRepository extends JpaRepository<W_Wf_Pas_Aut, W_Wf_Pas_AutPK> {

	@Query(value = "SELECT id_wf,id_paso,LTRIM(RTRIM(usuario)) as usuario,"
			+ "usu_ult_mod,fec_ult_mod,usu_crea,fec_crea FROM w_wf_pas_aut WHERE id_wf = :id AND id_paso = :idStep order by id_paso ASC ", nativeQuery = true)
	public List<W_Wf_Pas_Aut> findByWfAndStep(@Param("id") String id, @Param("idStep") String idStep);
	
	@Query(value = "SELECT u.Usuario,u.Nom_Usuario,CASE WHEN p.usuario IS NULL THEN 'false' ELSE 'true' END from W_Bas_Usuario u Left join w_wf_pas_aut p On u.Usuario =p.usuario AND p.id_paso =:id_paso ANd p.id_wf =:id_wf", nativeQuery = true)
	List<Object[]> findByUsuarioByStep(@Param("id_wf") String id_wf, @Param("id_paso") String id_paso);


	

}
