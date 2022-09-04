package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Cladoc;

@Repository
public interface CladocRepository extends JpaRepository<Cladoc, String> {

	@Query(value = "select codtip,nomtip from cladoc", nativeQuery = true)
	List<Cladoc> findAll();
}
