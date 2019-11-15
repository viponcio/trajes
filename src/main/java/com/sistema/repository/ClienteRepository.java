package com.sistema.repository;
import com.sistema.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//vai fazer o crud
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNomeCli(String nomeCli);


}

