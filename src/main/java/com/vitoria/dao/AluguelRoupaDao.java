package com.vitoria.dao;

import com.vitoria.model.AluguelRoupa;

import java.util.List;

public interface AluguelRoupaDao {
    List<AluguelRoupa> getByNomeCli(String codAluguelRoupa);
}
