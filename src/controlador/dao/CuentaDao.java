/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Cuenta;

/**
 *
 * @author Jean Pierre
 */
public class CuentaDao extends AdaptadorDao<Cuenta> {
    private Cuenta cuenta;

    public CuentaDao() {
        super(Cuenta.class);        
    }

    public Cuenta getCuenta() {
        if(cuenta == null)
            cuenta = new Cuenta();
        return cuenta;
    }
    /**
     * Metodo set que tiene como parametro cuenta
     * @param cuenta 
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    /**
     * metodo boolean que permite guardar o modificar 
     * @return devuelve un dato de tipo boolean
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if(cuenta.getId() != null) {
                modificar(cuenta);
            } else {
                guardar(cuenta);
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }
    /**
     * Metodo que nos permita iniciar sesion, con parametros usuario y clave
     * @param usuario
     * @param clave
     * @return 
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        Cuenta c =  null;
        try {
            Query q = getManager().createQuery("SELECT c FROM Cuenta c where c.usuario = :user");
            q.setParameter("user", usuario);
            Cuenta aux = (Cuenta)q.getSingleResult();
            if(aux != null && aux.getClave().equals(clave)) {
                c = aux;
            }  
        } catch (Exception e) {
        }
 
        return c;
    }
    
    
    
    
    
    
    
    
    
    
}
