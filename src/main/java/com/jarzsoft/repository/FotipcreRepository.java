package com.jarzsoft.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fotipcre;

@Repository
public interface FotipcreRepository extends JpaRepository<Fotipcre, String> {

	@Query(value = "select codigo_credito,nom_evolution,ran_int_1 from fotipcre where Activa = 'S' order by nom_evolution", nativeQuery = true)
	List<Fotipcre> findAll();

	@Query(value = "select * from fotipcre where codigo_credito =:linea", nativeQuery = true)
	Fotipcre findByCod(@Param("linea") String linea);

	@Query(value = "select c.ran_valor from cfi_t_pre_otr_det c, cfi_t_pre_otros cp where c.consecutivo = cp.consecutivo and c.codigo_credito = cp.codigo_credito and cp.ind_desembolso = 'S' and cp.codigo_credito = :linea and ( :monto >= ran_desde and :monto <=ran_hasta )", nativeQuery = true)
	List<Object[]> findRangueByEntitie(@Param("linea") String linea, @Param("monto") BigDecimal monto);

	@Query(value = "select c.porcentaje from cfi_t_pre_otr_det c, cfi_t_pre_otros cp where c.consecutivo = cp.consecutivo and c.codigo_credito = cp.codigo_credito and cp.ind_desembolso = 'S' and cp.codigo_credito = :linea and ( :monto >= ran_desde and :monto <=ran_hasta )", nativeQuery = true)
	List<Object[]> findRangueByEntitieP(@Param("linea") String linea, @Param("monto") BigDecimal monto);

}
