package com.sistema.repository;

import com.sistema.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
//vai fazer o crud
public interface FuncionarioRepository extends CrudRepository<Funcionario ,Long> {
}
