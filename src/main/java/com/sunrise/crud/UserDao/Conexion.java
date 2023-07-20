/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise.crud.UserDao;


import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author danie
 */
public class Conexion {
    private static final String URL_DB = "jdbc:mysql://localhost:3306/crud_cac?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static BasicDataSource dataSource;

    private Conexion() {}

    private static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                dataSource = new BasicDataSource();
                dataSource.setUrl(URL_DB);
                dataSource.setUsername(USERNAME);
                dataSource.setPassword(PASSWORD);
                dataSource.setInitialSize(50);
            } catch (Exception e) {
                throw new RuntimeException("Error al leer la configuración de la base de datos", e);
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
