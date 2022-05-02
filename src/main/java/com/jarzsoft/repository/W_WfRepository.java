package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.W_Wf;

@Repository
public interface W_WfRepository extends JpaRepository<W_Wf, Long> {

}
