package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

	@Query(value = "SELECT * FROM Usuarios WHERE codter = :codter", nativeQuery = true)
	Usuarios loadUserByCodter(@Param("codter") String codter);

}
