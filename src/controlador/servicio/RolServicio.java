/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.RolDao;
import java.util.List;
import modelo.Rol;

/**
 *
 * @author Jean Pierre
 */
public class RolServicio {
    private RolDao obj = new RolDao();
    /**
     * metodo get 
     * @return nos devuelve el rol
     */
    public Rol getRol() {
        return obj.getRol();
    }
    /**
     * Metodo guardar
     * @return nos devuelve el rol guardado
     */
    public boolean guardar() {
        return obj.guardar();
    }
    /**
     * Metodo todos
     * @return nos devuelve la lista de todos los roles.
     */
    public List<Rol> todos() {
        return obj.listar();
    }
    /**
     * Metodo obtener
     * @param id
     * @return nos devuelve la id obtenida del rol
     */
    public Rol obtener(Long id) {
        return obj.obtener(id);
    }
    /**
     * Metodo fijar con parametro rol
     * @param rol 
     */
    public void fijarRol(Rol rol) {
        obj.setRol(rol);
    }
    /**
     * Metodo buscar por el nombre del rol
     * @param nombre
     * @return nos devuelve la busqueda del nombre del rol 
     */
    public Rol buscarRolNombre(String nombre) {
        return obj.buscarRolNombre(nombre);
    }
    /**
     * Metodo para crear el tipo de rol que hay en el programa
     */
    public void crearRoles() {
        if(todos().isEmpty()) {
            getRol().setNombre("Administrador");
            guardar();
            fijarRol(null);
            getRol().setNombre("Estudiante");
            guardar();
            fijarRol(null);
        }
    }          
}








