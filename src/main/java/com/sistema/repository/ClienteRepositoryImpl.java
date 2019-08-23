package com.sistema.repository;

import com.sistema.model.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository {

    public ClienteRepositoryImpl() {
        super();
    }

    @Override
    public List<Cliente> findByNomeCli(String nomeCli) {
        return null;
    }

    @Override
    public <S extends Cliente> S save(S s) {
        return null;
    }

    @Override
    public <S extends Cliente> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Cliente> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return null;
    }

    @Override
    public Iterable<Cliente> findAllById(Iterable<Long> iterable) {
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
    public void delete(Cliente cliente) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
