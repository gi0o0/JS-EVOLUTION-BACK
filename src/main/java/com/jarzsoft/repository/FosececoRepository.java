package com.jarzsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fosececo;

@Repository
public interface FosececoRepository extends JpaRepository<Fosececo, String> {

	@Query(value = "SELECT * FROM fosececo WHERE codSec = :codSec", nativeQuery = true)
	public Fosececo findByParamId(@Param("codSec") String codSec);

	@Query(value = "SELECT * FROM fosececo WHERE codSec = :codSec AND nomSec = :nomSec", nativeQuery = true)
	public Fosececo findByParamIdAndParamtext(@Param("codSec") String codSec, @Param("nomSec") String nomSec);

}
