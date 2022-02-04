package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Bas_T_Perfil;

@Repository
public interface W_Bas_T_PerfilRepository extends JpaRepository<W_Bas_T_Perfil, Long> {

	@Query(value = "SELECT  max (codperfil ) +1 FROM w_bas_T_Perfil", nativeQuery = true)
	int getKey();

}
