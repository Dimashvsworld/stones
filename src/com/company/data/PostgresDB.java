package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {

    private Connection connection;

    public PostgresDB() throws SQLException, ClassNotFoundException {

        IDB idb = () -> {
            try {
                String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection(connectionUrl, "postgres", "123");

                return con;
            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }
        };

        connection = idb.getConnection();
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}