package com.sistema.repository;

import com.sistema.model.Funcionario;

import java.util.Optional;

public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    @Override
    public Funcionario findByEmailFunc(String emailFunc) {
        return null;
    }

    @Override
    public <S extends Funcionario> S save(S s) {
        return null;
    }

    @Override
    public <S extends Funcionario> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Funcionario> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Funcionario> findAll() {
        return null;
    }

    @Override
    public Iterable<Funcionario> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Funcionario funcionario) {

    }

    @Override
    public void deleteAll(Iterable<? extends Funcionario> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
