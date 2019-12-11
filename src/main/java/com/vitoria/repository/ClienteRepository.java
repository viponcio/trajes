package com.vitoria.repository;
import com.vitoria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//vai fazer o crud
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeCli(String nomeCli);
//    List<Cliente> findByNome(@Param("name") String name);


}

