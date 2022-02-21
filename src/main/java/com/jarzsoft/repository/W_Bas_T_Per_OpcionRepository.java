package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Bas_T_Per_Opcion;
import com.jarzsoft.entities.W_Bas_T_Per_OpcionPK;

@Repository
public interface W_Bas_T_Per_OpcionRepository extends JpaRepository<W_Bas_T_Per_Opcion,W_Bas_T_Per_OpcionPK> {

}
