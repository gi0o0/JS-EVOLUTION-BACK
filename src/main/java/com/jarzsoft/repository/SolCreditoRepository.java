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
	
	@Query(value = "WITH rads AS (" +
	        "  SELECT DISTINCT w.numero_radicacion FROM w_wf_mov w " +
	        "  WHERE w.id_wf = 4 AND w.id_paso <> '8' " +
	        "    AND (w.usu_comercial = :user OR w.usu_movimiento = :user OR w.usuario1 = :user " +
	        "      OR w.usuario2 = :user OR w.usuario3 = :user OR w.usuario4 = :user " +
	        "      OR EXISTS (SELECT wu.codperfil FROM W_Bas_Usuario wu WHERE wu.Usuario = :user AND wu.codperfil IN (1,3)))" +
	        "), paso AS (" +
	        "  SELECT numero_radicacion, MAX(id_paso) AS paso_actual FROM w_wf_mov WHERE id_wf = 4 GROUP BY numero_radicacion" +
	        ") " +
	        "SELECT s.NUMERO_RADICACION, s.estado, s.tasa_int, s.tipo_credito, s.tip_Sol_credito, " +
	        "s.bien_afecta, s.bien_hipoteca, s.bien__hip_a_favor, s.bien_nombre, s.bien_valor, " +
	        "s.veh_pignorado, s.veh_marca, s.veh_clase, s.veh_modelo, s.veh_placa, s.veh_pig_a_favor, s.veh_val_comercial, " +
	        "s.valor_pres, s.nro_cuotas, s.nro_cuenta, " +
	        "s.ref_nombre_1, s.ref_paren_1, s.ref_mail_1, s.ref_cel_1, " +
	        "s.ref_nombre_2, s.ref_paren_2, s.ref_mail_2, s.ref_cel_2, " +
	        "s.ref_nombre_3, s.ref_paren_3, s.ref_mail_3, s.ref_cel_3, " +
	        "s.codter AS sol_codter, s.observa, s.PER_CUOTA, s.ind_sol_credito, s.sol_pagare, s.cargo_deu_wf, " +
	        "s.sueldo, s.recargos, s.bonos, s.compensatorios, s.bonificacion, s.horas_extras, " +
	        "s.otros_pagos1, s.otros_pagos2, s.otros_pagos3, s.salud, s.pension, s.libranza, " +
	        "s.cuota_sindical, s.cuota_interna, s.otros_decuentos1, s.otros_decuentos2, s.otros_decuentos3, " +
	        "s.compra_cartera1, s.entidad_cartera1, s.obligacion_cartera1, s.compra_nit1, " +
	        "s.compra_cartera2, s.entidad_cartera2, s.obligacion_cartera2, s.compra_nit2, " +
	        "s.compra_cartera3, s.entidad_cartera3, s.obligacion_cartera3, s.compra_nit3, " +
	        "s.compra_cartera4, s.entidad_cartera4, s.obligacion_cartera4, s.compra_nit4, " +
	        "t.doctip, t.nitter, t.nom_tercero, t.pri_apellido, t.seg_apellido, t.lugardoc, t.mailter, t.dirterpal, " +
	        "t.telter, t.tel1ter, t.tel2ter, t.fe_exp, t.pais_codigo, t.codidept, t.codiciud, t.barrio, " +
	        "t.anti_empresa, t.tipvivienda, t.dirteralt, t.barrio_tra, t.pais_dir_trabajo, t.dept_dir_trabajo, " +
	        "t.ciu_dir_trabajo, t.faxter, t.ind_contrato, t.param_text, t.ent_ban, t.tip_cta, " +
	        "t.idconyuge, t.nom_cony, t.emailconyuge, t.celconyuge, t.dir_pais, t.dir_dep, t.dir_ciu, " +
	        "t.codter AS ter_codter, " +
	        "p.paso_actual " +
	        "FROM rads r " +
	        "JOIN SOL_CREDITO s ON s.numero_radicacion = r.numero_radicacion " +
	        "LEFT JOIN terceros t ON t.codter = s.codter " +
	        "LEFT JOIN paso p ON p.numero_radicacion = s.numero_radicacion " +
	        "WHERE s.estado NOT IN ('P', 'A', 'D', 'N', 'C')",
	        nativeQuery = true)
	List<Object[]> findAllByUserFull(@Param("user") String user);
	
	
	@Query(value = "WITH paso AS (" +
	        "  SELECT numero_radicacion, MAX(id_paso) AS paso_actual FROM w_wf_mov WHERE id_wf = 4 GROUP BY numero_radicacion" +
	        ") " +
	        "SELECT s.NUMERO_RADICACION, s.estado, s.tasa_int, s.tipo_credito, s.tip_Sol_credito, " +
	        "s.bien_afecta, s.bien_hipoteca, s.bien__hip_a_favor, s.bien_nombre, s.bien_valor, " +
	        "s.veh_pignorado, s.veh_marca, s.veh_clase, s.veh_modelo, s.veh_placa, s.veh_pig_a_favor, s.veh_val_comercial, " +
	        "s.valor_pres, s.nro_cuotas, s.nro_cuenta, " +
	        "s.ref_nombre_1, s.ref_paren_1, s.ref_mail_1, s.ref_cel_1, " +
	        "s.ref_nombre_2, s.ref_paren_2, s.ref_mail_2, s.ref_cel_2, " +
	        "s.ref_nombre_3, s.ref_paren_3, s.ref_mail_3, s.ref_cel_3, " +
	        "s.codter AS sol_codter, s.observa, s.PER_CUOTA, s.ind_sol_credito, s.sol_pagare, s.cargo_deu_wf, " +
	        "s.sueldo, s.recargos, s.bonos, s.compensatorios, s.bonificacion, s.horas_extras, " +
	        "s.otros_pagos1, s.otros_pagos2, s.otros_pagos3, s.salud, s.pension, s.libranza, " +
	        "s.cuota_sindical, s.cuota_interna, s.otros_decuentos1, s.otros_decuentos2, s.otros_decuentos3, " +
	        "s.compra_cartera1, s.entidad_cartera1, s.obligacion_cartera1, s.compra_nit1, " +
	        "s.compra_cartera2, s.entidad_cartera2, s.obligacion_cartera2, s.compra_nit2, " +
	        "s.compra_cartera3, s.entidad_cartera3, s.obligacion_cartera3, s.compra_nit3, " +
	        "s.compra_cartera4, s.entidad_cartera4, s.obligacion_cartera4, s.compra_nit4, " +
	        "t.doctip, t.nitter, t.nom_tercero, t.pri_apellido, t.seg_apellido, t.lugardoc, t.mailter, t.dirterpal, " +
	        "t.telter, t.tel1ter, t.tel2ter, t.fe_exp, t.pais_codigo, t.codidept, t.codiciud, t.barrio, " +
	        "t.anti_empresa, t.tipvivienda, t.dirteralt, t.barrio_tra, t.pais_dir_trabajo, t.dept_dir_trabajo, " +
	        "t.ciu_dir_trabajo, t.faxter, t.ind_contrato, t.param_text, t.ent_ban, t.tip_cta, " +
	        "t.idconyuge, t.nom_cony, t.emailconyuge, t.celconyuge, t.dir_pais, t.dir_dep, t.dir_ciu, " +
	        "t.codter AS ter_codter, " +
	        "p.paso_actual " +
	        "FROM SOL_CREDITO s " +
	        "LEFT JOIN terceros t ON t.codter = s.codter " +
	        "LEFT JOIN paso p ON p.numero_radicacion = s.numero_radicacion " +
	        "WHERE s.NUMERO_RADICACION IN (:ids)",
	        nativeQuery = true)
	List<Object[]> findAllByIdsFull(@Param("ids") List<Integer> ids);

}
