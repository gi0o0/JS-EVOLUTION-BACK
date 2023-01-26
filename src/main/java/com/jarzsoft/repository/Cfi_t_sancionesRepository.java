package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Cfi_t_sanciones;

@Repository
public interface Cfi_t_sancionesRepository extends JpaRepository<Cfi_t_sanciones, String> {

	@Query(value = "select * from Cfi_t_sanciones where codter = :user and estado = 0", nativeQuery = true)
	List<Cfi_t_sanciones> getUserSanciones(@Param("user") String user);
}
