/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author william.alvarez
 */
public class Conexion {

    public Connection conn = null;

    public Conexion() {
    }

    public boolean cerrarCx() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection connect() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "coupa", "coupatest");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR CONEXION BASE DE DATOS " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
