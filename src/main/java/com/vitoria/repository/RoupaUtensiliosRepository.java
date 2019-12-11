package com.vitoria.repository;

import com.vitoria.model.RoupaUtensilios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoupaUtensiliosRepository extends JpaRepository<RoupaUtensilios,Long> {
}
