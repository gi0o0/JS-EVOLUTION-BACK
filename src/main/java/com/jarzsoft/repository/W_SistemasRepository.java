package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_sistemas;

@Repository
public interface W_SistemasRepository extends JpaRepository<W_sistemas, Integer> {

}
