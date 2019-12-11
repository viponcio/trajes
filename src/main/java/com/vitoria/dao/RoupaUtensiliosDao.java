package com.vitoria.dao;

import com.vitoria.model.RoupaUtensilios;

import java.util.List;

public interface RoupaUtensiliosDao {
     List<RoupaUtensilios> getByCor(String cor);

     boolean alterar(RoupaUtensilios ru);
}
