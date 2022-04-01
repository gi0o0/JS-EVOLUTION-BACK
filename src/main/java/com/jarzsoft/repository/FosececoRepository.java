package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Fosececo;
import java.util.List;

@Repository
public interface FosececoRepository extends JpaRepository<Fosececo, String> {

	@Query(value = "SELECT LTRIM(RTRIM(codsec)) as codsec, LTRIM(RTRIM(nomsec)) as nomsec,usu_ult_mod, fec_ult_mod, fec_crea, usu_crea FROM fosececo order by codsec ", nativeQuery = true)
	public List<Fosececo>  findComplete();

	
	@Query(value = "SELECT LTRIM(RTRIM(codsec)) as codsec, LTRIM(RTRIM(nomsec)) as nomsec,usu_ult_mod, fec_ult_mod, fec_crea, usu_crea FROM fosececo WHERE codsec = :codSec", nativeQuery = true)
	public Fosececo findByParamId(@Param("codSec") String codSec);

	@Query(value = "SELECT LTRIM(RTRIM(codsec)) as codsec, LTRIM(RTRIM(nomsec)) as nomsec,usu_ult_mod, fec_ult_mod, fec_crea, usu_crea FROM fosececo WHERE codsec = :codSec AND nomsec = :nomSec", nativeQuery = true)
	public Fosececo findByParamIdAndParamtext(@Param("codSec") String codSec, @Param("nomSec") String nomSec);

}
