/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.CuentaDao;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import modelo.Cuenta;

/**
 *
 * @author Jean Pierre
 */
public class CuentaServicio {
    private CuentaDao obj = new CuentaDao();
    
    /**
     * Metodo get 
     * @return nos devuelve la cuenta
     */
    public Cuenta getCuenta() {
        return obj.getCuenta();
    }
    /**
     * Metodo que nos permite guardar.
     * @return nos devuelve la cuenta guardada
     */
    public boolean guardar() {
        return obj.guardar();
    }
    /**
     * Metodo todos 
     * @return nos devuelve la lista de todas las cuentas
     */
    public List<Cuenta> todos() {
        return obj.listar();
    }
    /**
     * Metodo obtener
     * @param id
     * @return nos devuelve la id obtenida de la cuenta 
     */
    public Cuenta obtener(Long id) {
        return obj.obtener(id);
    }
    /**
     * Metodo que permite fijar una cuenta, con parametro cuenta
     * @param cuenta 
     */
    public void fijarCuenta(Cuenta cuenta) {
        obj.setCuenta(cuenta);
    }
    /**
     * Metodo que permite crear una cuenta Administrador.
     */
    public void crearCuentaAdmin() {
        if(todos().isEmpty()) {
            PersonaServicio persona = new PersonaServicio();
            persona.getPersona().setApellidos("Chimbo");
            persona.getPersona().setNombres("Jean");
            persona.getPersona().setCedula("0706451861");
            persona.getPersona().setDireccion("Huaquillas");
            persona.getPersona().setExternal_id(UUID.randomUUID().toString());
            persona.getPersona().setTelefono("S/T");
            persona.getPersona().setRol(new RolServicio().buscarRolNombre("Administrador"));
            Cuenta c = new Cuenta();
            c.setClave("pass");
            c.setUsuario("admin");
            c.setExternal_id(UUID.randomUUID().toString());
            c.setCreated_at(new Date());
            c.setUpdated_at(new Date());
            c.setPersona(persona.getPersona());
            persona.getPersona().setCuenta(c);
            persona.guardar();            
        }
    }
    /**
     * Metodo que permite iniciar sesio con parametros usuario y clave
     * @param usuario
     * @param clave
     * @return nos devuelve el usuario y clave
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        return obj.inicioSesion(usuario, clave);
    }
            
}








