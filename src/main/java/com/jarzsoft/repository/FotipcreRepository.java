package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fotipcre;

@Repository
public interface FotipcreRepository extends JpaRepository<Fotipcre, String> {

	@Query(value = "select codigo_credito,nom_evolution from fotipcre where Activa = 'S' order by nom_evolution", nativeQuery = true)
	List<Fotipcre> findAll();
}
