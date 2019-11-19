package com.sistema.security;

import com.sistema.model.Funcionario;
import com.sistema.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ImplementsFuncionarioDetailsService implements UserDetailsService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByUsername(username);
        if(funcionario == null){
            throw new UsernameNotFoundException("USER NÃO ENCONTRADO");
        }
        System.out.println("username:"+funcionario.getUsername()+" password:"+funcionario.getPassword());
        return new User(funcionario.getUsername(),funcionario.getPassword(),true,true,true,true,funcionario.getAuthorities());//se o funcionario for encontrado retorna ele
    }
}
