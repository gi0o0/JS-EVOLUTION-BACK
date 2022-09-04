package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Baentida;

@Repository
public interface BaentidadRepository extends JpaRepository<Baentida, String> {

	@Query(value = "select codent,noment from baentida", nativeQuery = true)
	List<Baentida> findAll();
}
