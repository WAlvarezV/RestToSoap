/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import entity.Empleado;

/**
 *
 * @author william.alvarez
 */
public class EmpleadoDao {

    public synchronized void create(Connection conn, Empleado valueObject) throws SQLException {

        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
            sql = "INSERT INTO EMPLEADO ( NOMBRES, APELLIDOS, TIPO_DOCUMENTO, NUMERO_DOCUMENTO, FECHA_NACIMIENTO, FECHA_VINCULACION, CARGO, SALARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, valueObject.getNombres());
            stmt.setString(2, valueObject.getApellidos());
            stmt.setString(3, valueObject.getTipoDocumento());
            stmt.setString(4, valueObject.getNumeroDocumento());
            stmt.setString(5, valueObject.getFechaNacimiento());
            stmt.setString(6, valueObject.getFechaVinculacion());
            stmt.setString(7, valueObject.getCargo());
            stmt.setDouble(8, valueObject.getSalario());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                //System.out.println("PrimaryKey Error when updating DB!");
                throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }
}
