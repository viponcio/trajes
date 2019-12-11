package com.vitoria.repository;

import com.vitoria.model.TipoRoupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRoupaRepository extends JpaRepository<TipoRoupa, Long> {
}
