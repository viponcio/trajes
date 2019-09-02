package com.sistema.repository;
import com.sistema.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//vai fazer o crud
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNomeCli(String nomeCli);
}

