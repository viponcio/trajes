package com.sistema.security;

import com.sistema.model.Funcionario;
import com.sistema.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
@Repository
public class ImplementsFuncionarioDetailsService implements UserDetailsService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public UserDetails loadUserByUsername(String emailFunc) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByEmailFunc(emailFunc);
        if(funcionario == null){
            throw new UsernameNotFoundException("USER NÃO ENCONTRADO");
        }
        return funcionario;
    }
}
