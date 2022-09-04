package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Ciudades;

@Repository
public interface CiudadesRepository extends JpaRepository<Ciudades, Integer> {

	@Query(value = "select codiciud,nombciud from ciudades where pais_codigo=:paisCodigo and codidept= :deptosCodigo order by nombciud", nativeQuery = true)
	List<Ciudades> findAll(@Param("paisCodigo") Integer paisCodigo, @Param("deptosCodigo") Integer deptosCodigo);
}
