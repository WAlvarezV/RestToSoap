/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Empleado;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import logic.GestionEmpleado;

/**
 *
 * @author william.alvarez
 */
@WebService(serviceName = "SoapService")
public class SoapService {

    
    
    GestionEmpleado gestion;
    public SoapService() {
        gestion = new GestionEmpleado();
    }
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "crearEmpleado")
    public Empleado crearEmpleado(@WebParam(name = "name") Empleado obj) {
        return gestion.crearEmpleado(obj);
    }
}
