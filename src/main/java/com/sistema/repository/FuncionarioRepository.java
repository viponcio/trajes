package com.sistema.repository;

import com.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//vai fazer o crud
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario ,Long> {
//    Funcionario findByEmailFunc(String emailFunc);
    Funcionario findByUsername(String username);
}
