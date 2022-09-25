package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fodataso;

@Repository
public interface FodatasoRepository extends JpaRepository<Fodataso, String> {

	@Query(value = "SELECT * FROM FODATASO WHERE cod_ter = :codTer", nativeQuery = true)
	Fodataso findByCodTer(@Param("codTer") String codTer);

}
