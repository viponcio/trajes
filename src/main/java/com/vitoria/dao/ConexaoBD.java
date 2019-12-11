package com.vitoria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String url="jdbc:mysql://localhost:3306/trajesdb?useTimezone=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "root";//senha do meu banco

    public static void main(String[] args) {
        new ConexaoBD().getConexao();
    }

    public Connection getConexao(){
                Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return conn;

    }
}
