package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Integer> {

	@Query(value = "select pais_codigo,pais_nombre from paises order by pais_nombre", nativeQuery = true)
	List<Paises> findAll();
}
