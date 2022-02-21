package com.jarzsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarzsoft.entities.Folog;

@Repository
public interface FologRepository extends JpaRepository<Folog, String> {

}
