package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Men_Opcion;

@Repository
public interface W_Men_OpcionRepository extends JpaRepository<W_Men_Opcion, Integer> {

	@Query(value = "SELECT s.numero_sistema,LTRIM(RTRIM( s.nombre_sistema)) as nombre_sistema   ,LTRIM(RTRIM( s.page)) as page , LTRIM(RTRIM( s.icon)) as icon, mo.cod_opcion, LTRIM(RTRIM(mo.nom_opcion)) as nom_opcion , LTRIM(RTRIM(mo.page)) as url FROM w_sistemas s, w_men_opcion mo, w_bas_T_Per_Opcion po "
			+ " WHERE (mo.numero_sistema = s.numero_sistema)" + " AND po.codperfil =  :codperfil"
			+ " AND po.cod_opcion = mo.cod_opcion" + " ORDER BY s.nombre_sistema, mo.nom_opcion", nativeQuery = true)
	List<Object[]> findByCodPerfil(@Param("codperfil") int codperfil);

	@Query(value = "SELECT OP.COD_OPCION ,LTRIM(RTRIM(OP.NOM_OPCION)) as NOM_OPCION,PER.CODPERFIL FROM W_MEN_OPCION OP LEFT JOIN W_BAS_T_PER_OPCION PER ON OP.COD_OPCION = PER.COD_OPCION AND PER.CODPERFIL =:codperfil WHERE NUMERO_SISTEMA =:numsistema", nativeQuery = true)
	List<Object[]> findOpcionesBySystem(@Param("numsistema") String numsistema,@Param("codperfil") String codperfil);

}
