package com.jarzsoft.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fotabpro;

@Repository
public interface FotabproRepository extends JpaRepository<Fotabpro, BigInteger> {

	@Query(value = "select cod_inter,nom_profe from fotabpro order by nom_profe", nativeQuery = true)
	List<Fotabpro> findAll();
}
