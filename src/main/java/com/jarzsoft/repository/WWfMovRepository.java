package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
