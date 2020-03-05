/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import common.Conexion;
import java.util.List;
import entity.Empleado;
import dao.EmpleadoDao;
import java.sql.Connection;

/**
 *
 * @author william.alvarez
 */
public class GestionEmpleado {
    Conexion conexion;
    Connection conn;
    EmpleadoDao dao;
    
    public GestionEmpleado() {
        super();
        conexion = new Conexion();
        dao = new EmpleadoDao();
    }
    
    public Empleado crearEmpleado(Empleado obj) {
        try {
            conn = conexion.connect();
            dao.create(conn, obj);            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
}
