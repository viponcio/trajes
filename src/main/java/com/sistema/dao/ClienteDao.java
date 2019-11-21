package com.sistema.dao;

import com.sistema.model.Cliente;

import java.util.List;

public interface ClienteDao {
    List<Cliente> getByNomeCli(String nomeCli);
}
