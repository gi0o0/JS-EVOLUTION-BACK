package com.jarzsoft.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Parametro;
import com.jarzsoft.entities.ParametroKey;

@Repository
public interface ParametroRepository extends JpaRepository<Parametro, ParametroKey> {

	
	
	@Query(value = "SELECT * FROM parametro WHERE param_id = :param_id order by value", nativeQuery = true)
	public List<Parametro> findByParamId(@Param("param_id") String param_id);
	
	@Query(value = "SELECT * FROM parametro WHERE param_id = :param_id AND param_text = :param_text", nativeQuery = true)
	public Parametro findByParamIdAndParamtext(@Param("param_id") String param_id,@Param("param_text") String param_text);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE parametro SET value = value+1 WHERE  param_id = :param_id AND param_text = :param_text", nativeQuery = true)
	public void aumentarConsecutivoPagare(@Param("param_id") String param_id,@Param("param_text") String param_text);

}
