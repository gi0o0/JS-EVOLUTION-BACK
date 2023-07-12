package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf_Prestamo;
import com.jarzsoft.entities.W_Wf_PrestamoPK;

@Repository
public interface W_Wf_PrestamosRepository extends JpaRepository<W_Wf_Prestamo, W_Wf_PrestamoPK> {

	@Query(value = "select  w.id_wf ,w.numero_radicacion,	w.numero_credito,w.ind_est,w.ind_cer,w.ind_cer_deu,w.ind_paz,w.ind_dp,(select f.nom_claaso from foclaaso f where f.cod_inter=  w.cla_asoci ) pagaduria "
			+ " from w_wf_prestamo w where id_wf = :idWf and numero_radicacion = :numRad order by w.numero_radicacion,	w.numero_credito", nativeQuery = true)
	public List<Object[]> findByWfByNumRad(@Param("idWf") Integer idWf, @Param("numRad") Integer numRad);

}
