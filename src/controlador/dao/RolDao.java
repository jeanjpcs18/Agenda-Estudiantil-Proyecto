/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import javax.persistence.Query;
import modelo.Rol;

/**
 *
 * @author Jean Pierre
 */
public class RolDao extends AdaptadorDao<Rol> {
    private Rol rol;

    public RolDao() {
        super(Rol.class);        
    }
    /**
     * Metodo get
     * @return nos devuelve el rol
     */
    public Rol getRol() {
        if(rol == null)
            rol = new Rol();
        return rol;
    }
    /**
     * Metodo set que tiene como parametro rol
     * @param rol 
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }   
    /**
     * Metodo guardar nos perimite modificar y guardar
     * @return nos devuelve un tipo de dato boolean
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if(rol.getId() != null) {
                modificar(rol);
            } else {
                guardar(rol);
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }
    /**
     * metodo buscar rol
     * @param nombre
     * @return nos devuelve el nombre del rol 
     */
    public Rol buscarRolNombre(String nombre) {
        Rol r = null;
        try {
            Query q = getManager().createQuery("SELECT r FROM Rol r where r.nombre = :data");
            q.setParameter("data", nombre);
            r = (Rol) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("No se pudo encontrar el rol por nombre "+e);
        }
        return r;
    }
    
    
    
    
    
    
    
    
    
    
}
