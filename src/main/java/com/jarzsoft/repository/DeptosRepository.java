package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Deptos;

@Repository
public interface DeptosRepository extends JpaRepository<Deptos, Integer> {

	@Query(value = "select codidept,nombdept from deptos where pais_codigo=:paisCodigo order by nombdept", nativeQuery = true)
	List<Deptos> findAll(@Param("paisCodigo") Integer paisCodigo);
}
