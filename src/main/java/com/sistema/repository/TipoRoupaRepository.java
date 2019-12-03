package com.sistema.repository;

import com.sistema.model.TipoRoupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRoupaRepository extends JpaRepository<TipoRoupa, Long> {
}
