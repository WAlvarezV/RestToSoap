/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import dto.EmpleadoDto;
import utilities.Functions;

/**
 *
 * @author william.alvarez
 */
public class SoapClient {

    SoapService_Service obj = new SoapService_Service();
    SoapService service = obj.getSoapServicePort();
    Functions fn = new Functions();

    public SoapClient() {
    }
    
    

    public EmpleadoDto CrearEmpleado(EmpleadoDto dto) {
        try {
            String val = "";
            
            Empleado emp = new Empleado();
            if (!dto.getNombres().equals("") && dto.getNombres() != null) {
                emp.nombres = dto.getNombres();
            } else {
                val += "Los nombres no pueden ser vacios o null\n";
            }

            if (!dto.getApellidos().equals("") && dto.getApellidos() != null) {
                emp.apellidos = dto.getApellidos();
            } else {
                val += "Los apellidos no pueden ser vacios o null\n";
            }

            if (!dto.getTipoDocumento().equals("") && dto.getTipoDocumento() != null) {
                emp.tipoDocumento = dto.getTipoDocumento();
            } else {
                val += "El tipo de documento no puede ser vacio o null\n";
            }

            if (!dto.getNumeroDocumento().equals("") && dto.getNumeroDocumento() != null) {
                emp.numeroDocumento = dto.getNumeroDocumento();
            } else {
                val += "El numero de documento no puede ser vacio o null\n";
            }

            if (!dto.getFechaNacimiento().equals("") && dto.getNombres() != null) {
                if (fn.esMayor(dto.getFechaNacimiento())) {
                    emp.fechaNacimiento = fn.strOracleFormat(dto.getFechaNacimiento());
                } else {
                    val += "El empleado no es mayor de edad\n";
                }
            } else {
                val += "la fecha de nacimiento no puede ser vacio o null\n";
            }

            if (!dto.getFechaVinculacion().equals("") && dto.getFechaVinculacion() != null) {
                emp.fechaVinculacion = fn.strOracleFormat(dto.getFechaVinculacion());
            } else {
                val += "la fecha de vinculacion no puede ser vacio o null\n";
            }

            if (!dto.getCargo().equals("") && dto.getCargo() != null) {
                emp.cargo = dto.getCargo();
            } else {
                val += "El cargo no puede ser vacio o null\n";
            }

            if (dto.getSalario() >= 1) {
                emp.salario = dto.getSalario();
            } else {
                val += "El salario no puede ser menor o igual a 0\n";
            }

            if (val.equals("")) {                
                service.crearEmpleado(emp);
                dto.setEdad(fn.getEdad(dto.getFechaNacimiento()));
                dto.setTiempoVinculacion(fn.getEdad(dto.getFechaVinculacion()));
                return dto;
            } else {
                dto = new EmpleadoDto();
                dto.setValidacion(val);
                return dto;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            dto = new EmpleadoDto();
            dto.setValidacion(ex.getMessage());
            return dto;
        }

    }

}
