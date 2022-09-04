package com.jarzsoft.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Terceros;

@Repository
public interface TercerosRepository extends JpaRepository<Terceros, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE terceros SET mailter= :mailter WHERE codter= :codter", nativeQuery = true)
	public void modificarEmail(@Param("codter") BigDecimal codter, @Param("mailter") String mailter);

	@Query(value = "SELECT * FROM Terceros WHERE nitter = :nitter", nativeQuery = true)
	Terceros findByNiter(@Param("nitter") String nitter);
	
	@Query(value = "SELECT * FROM Terceros WHERE codter = :codter", nativeQuery = true)
	Terceros findByCodter(@Param("codter") String codter);
	
	@Query(value = "SELECT  max (codter ) +1 FROM Terceros", nativeQuery = true)
	int getKey();
	

}
