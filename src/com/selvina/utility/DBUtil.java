/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Selvina NS (1172149)
 */
public class DBUtil {

    public static Connection createMySQLConnection() throws
            ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://host:port/dbname", "username", "password");
        connection.setAutoCommit(false);
        return connection;
    }
}
