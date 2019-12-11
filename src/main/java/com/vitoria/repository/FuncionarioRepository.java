package com.vitoria.repository;

import com.vitoria.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//vai fazer o crud
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario ,Long> {
//    Funcionario findByEmailFunc(String emailFunc);
    Funcionario findByUsername(String username);
}
