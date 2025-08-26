package com.jarzsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.SolCredito;

@Repository
public interface SolCreditoRepository extends JpaRepository<SolCredito, Integer> {

	@Query(value = "SELECT * FROM SOL_CREDITO WHERE codter = :codTer AND tipo_credito= :tipoCredito And estado IN ('S','I','E')", nativeQuery = true)
	SolCredito findByNiter(@Param("codTer") String codTer, @Param("tipoCredito") String tipoCredito);

	@Query(value = "SELECT * FROM SOL_CREDITO WHERE NUMERO_RADICACION = :NumRad", nativeQuery = true)
	SolCredito findByNumRad(@Param("NumRad") String NumRad);

	@Query(value = "select DISTINCT s.numero_radicacion,s.estado from w_wf_mov w, SOL_CREDITO s where w.id_wf = 4 and w.numero_radicacion = s.numero_radicacion "
			+ "and (w.usu_comercial = :user or w.usu_movimiento = :user or w.usuario1 = :user or w.usuario2 = :user or w.usuario3 = :user or w.usuario4 = :user "
			+ "or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = :user and wu.codperfil in (1,3) ) ) and (w.id_paso <>'8' and s.estado not in ('P', 'A', 'D', 'N', 'C')) ", nativeQuery = true)
	List<Object[]> findByUser(@Param("user") String user);

	@Query(value = "SELECT CASE WHEN max(NUMERO_RADICACION) IS NULL THEN 1 ELSE  max (NUMERO_RADICACION )+1 END FROM SOL_CREDITO", nativeQuery = true)
	int getKey();

	@Transactional
	@Modifying
	@Query(value = "UPDATE SOL_CREDITO SET estado = :estado WHERE NUMERO_RADICACION= :numeroRadicacion ", nativeQuery = true)
	public void modificarEstado(@Param("numeroRadicacion") Integer numeroRadicacion, @Param("estado") String estado);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SOL_CREDITO SET clave_link= :hash WHERE NUMERO_RADICACION= :numeroRadicacion", nativeQuery = true)
	public void modificarClaveLink(@Param("numeroRadicacion") String numeroRadicacion, @Param("hash") String hash);

	@Query(value = "SELECT * FROM SOL_CREDITO WHERE clave_link = :hash", nativeQuery = true)
	SolCredito findByHash(@Param("hash") String hash);

	@Transactional
	@Modifying
	@Query(value = "UPDATE SOL_CREDITO " + "SET estado = :estado "
			+ "WHERE DATEDIFF(DAY, fecha_soli, GETDATE()) > :dias "
			+ "AND estado NOT IN ('P', 'A', 'D', 'N', 'C')", nativeQuery = true)
	public void modificarEstadoExDias(@Param("estado") String nuevoEstado, @Param("dias") int dias);

}
