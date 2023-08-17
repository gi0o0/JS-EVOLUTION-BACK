package com.jarzsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.WWfMov;

@Repository
public interface WWfMovRepository extends JpaRepository<WWfMov, Integer> {

	@Query(value = "SELECT CASE WHEN max(id_wf_mov) IS NULL THEN 1 ELSE  max (id_wf_mov)+1 END FROM w_wf_mov", nativeQuery = true)
	int getKey();

	@Query(value = "SELECT * FROM w_wf_mov WHERE numero_radicacion = :idRad AND id_wf= :idWf AND  id_paso= :idPaso", nativeQuery = true)
	WWfMov findMovByNumRad(@Param("idRad") Integer idRad, @Param("idWf") String idWf, @Param("idPaso") String idPaso);

	@Query(value = "SELECT MAX(id_paso) FROM w_wf_mov WHERE numero_radicacion = :idRad AND id_wf= :idWf", nativeQuery = true)
	Integer findMaxMovByNumRad(@Param("idRad") Integer idRad, @Param("idWf") String idWf);

	@Query(value = "select * from w_wf_mov wm, w_wf wf where  wm.id_wf = wf.id_wf and wm.id_wf < 4 and wm.est_paso <> 99 and (wm.usu_movimiento = :user or  wm.usu_comercial = :user "
			+ " or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = :user and wu.codperfil = 2 )) and wm.id_wf_mov = (select MAX(wm1.id_wf_mov) from w_wf_mov wm1 where  wm1.id_wf < 4 and wm1.est_paso <> 99"
			+ " and wm.numero_radicacion = wm1.numero_radicacion and (wm1.usu_movimiento = :user or  wm1.usu_comercial = :user"
			+ " or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = :user and wu.codperfil = 2 ) ) ) order by wm.id_wf_mov desc", nativeQuery = true)
	List<WWfMov> findMovByUser(@Param("user") String user);

	@Query(value = "SELECT * FROM w_wf_mov WHERE numero_radicacion = :idRad AND id_wf= :idWf AND  id_paso= :idPaso  order by id_wf_mov desc", nativeQuery = true)
	List<WWfMov> findListMovByNumRad(@Param("idRad") Integer idRad, @Param("idWf") String idWf,
			@Param("idPaso") String idPaso);

	@Transactional
	@Modifying
	@Query(value = "UPDATE w_wf_mov SET est_paso = :estado WHERE numero_radicacion= :numero_radicacion ", nativeQuery = true)
	public void modificarEstado(@Param("numero_radicacion") Integer numero_radicacion, @Param("estado") String estado);

	@Query(value = "select wm.id_wf , wm.id_paso, wm.comentarios, wm.est_paso,wm.numero_radicacion,wm.id_wf_mov ,wm.nitter ,wf.nom_wf,step.nom_paso ,wm.fec_ult_mod,wm.usu_comercial,ter.nomTer from w_wf_mov wm, w_wf wf,w_wf_pasos step , terceros ter where "
			+ " wm.id_wf = wf.id_wf and (wm.id_wf = step.id_wf and wm.id_paso =step.id_paso ) and wm.id_wf < 4 and wm.est_paso <> 99 and (wm.usu_movimiento = :user or  wm.usu_comercial = :user "
			+ "	or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = :user and wu.codperfil = 2 )) and wm.id_wf_mov = (select MAX(wm1.id_wf_mov) from w_wf_mov wm1 where  wm1.id_wf < 4 and wm1.est_paso <> 99 "
			+ "	and wm.numero_radicacion = wm1.numero_radicacion and (wm1.usu_movimiento = :user or  wm1.usu_comercial =:user "
			+ "	or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = :user and wu.codperfil = 2 ) ) ) and ter.nitter =wm.nitter order by wm.id_wf_mov desc", nativeQuery = true)
	List<Object[]> findMovByUserCustom(@Param("user") String user);

}
