package com.vitoria.dao;

import com.vitoria.model.Cliente;

import java.util.List;

public interface ClienteDao {
    List<Cliente> getByNomeCli(String nomeCli);
}
