package br.com.alurasenac.farmacia.dao;

import java.sql.Connection;
import java.sql.SQLException;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conectyfactory {

    public Connection recuperarConexao() {
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/farmacia");
        config.setUsername("root");
        config.setPassword("Casa9811*");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
    }

