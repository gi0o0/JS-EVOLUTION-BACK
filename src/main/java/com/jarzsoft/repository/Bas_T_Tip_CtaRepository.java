package com.jarzsoft.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Bas_T_Tip_Cta;

@Repository
public interface Bas_T_Tip_CtaRepository extends JpaRepository<Bas_T_Tip_Cta, BigInteger> {

	@Query(value = "select id_tip_cta,Nom_cta from bas_T_Tip_Cta order by Nom_cta", nativeQuery = true)
	List<Bas_T_Tip_Cta> findAll();
}
