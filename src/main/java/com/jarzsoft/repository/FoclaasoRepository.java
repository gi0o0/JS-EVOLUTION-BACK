package com.jarzsoft.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Foclaaso;

@Repository
public interface FoclaasoRepository extends JpaRepository<Foclaaso, BigInteger> {

	@Query(value = "select foclaaso.* from foclaaso, fotabase_com where foclaaso.Activa = 'S' and  foclaaso.cod_inter  = fotabase_com.cod_inter and fotabase_com.codter_asesor = :usuario order by foclaaso.nom_claaso", nativeQuery = true)
	List<Foclaaso> findByUsuario(@Param("usuario") String usuario);

	@Query(value = "select * from foclaaso where cod_inter in ( select fo.cla_asoci  from fodataso fo where fo.cod_ter =:codTer)  ", nativeQuery = true)
	Foclaaso findByCodter(@Param("codTer") Integer codTer);

}
