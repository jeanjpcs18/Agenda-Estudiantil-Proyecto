/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.PersonaDao;
import java.util.List;
import modelo.Materia;
import modelo.Persona;

/**
 *
 * @author Jean Pierre
 */
public class PersonaServicio {
    private PersonaDao obj = new PersonaDao();
    /**
     * Metodo get 
     * @return nos devuelve la persona
     */
    public Persona getPersona() {
        return obj.getPersona();
    }
    /**
     * Metodo guardar
     * @return nos devuelve la persona creada
     */
    public boolean guardar() {
        return obj.guardar();
    }
    /**
     * Metodo listar 
     * @return nos devuelve la lista de todas las personas
     */
    public List<Persona> todos() {
        return obj.listar();
    }
    /**
     * Metodo obtener
     * @param id
     * @return nos devuelve la id obtenida de la persona
     */
    public Persona obtener(Long id) {
        return obj.obtener(id);
    }
    /**
     * Metodo fijarpersona con parametro persona 
     * @param persona 
     */
    public void fijarPersona(Persona persona) {
        obj.setPersona(persona);
    }
    /**
     * Metodo get 
     * @param cedula
     * @return nos devuelve la cedula obtenida de la persona 
     */
    public Persona getPersonaCedula(String cedula) {
        return obj.getPersonaCedula(cedula);
    }
}








