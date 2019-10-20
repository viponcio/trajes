package com.sistema.repository;

import com.sistema.model.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//vai fazer o crud
@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario ,Long> {
    Funcionario findByEmailFunc(String emailFunc);
}
