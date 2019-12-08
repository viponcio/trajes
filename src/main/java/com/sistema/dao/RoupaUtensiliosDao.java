package com.sistema.dao;

import com.sistema.model.RoupaUtensilios;

import java.util.List;

public interface RoupaUtensiliosDao {
     List<RoupaUtensilios> getByCor(String cor);

     boolean alterar(RoupaUtensilios ru);
}
