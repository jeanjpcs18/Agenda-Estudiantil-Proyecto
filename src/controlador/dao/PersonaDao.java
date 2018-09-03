/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Persona;

/**
 *
 * @author Jean Pierre
 */
public class PersonaDao extends AdaptadorDao<Persona> {
    private Persona persona;

    public PersonaDao() {
        super(Persona.class);        
    }
    /**
     * Metodo get
     * @return nos devuelve la persona. 
     */
    public Persona getPersona() {
        if(persona == null)
            persona = new Persona();
        return persona;
    }
    /**
     * Metodo set que tiene como parametro una persona
     * @param persona 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    /**
     * Metodo que permite guardar y modificar una persona 
     * @return nos devuelve un tipo de dato boolean
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            getManager().getTransaction().begin();
            if(persona.getId() != null) {
                modificar(persona);
            } else {
                guardar(persona);
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }
    
    /**
     * Metodo get que tiene como parametro la cedula.
     * @param cedula
     * @return nos devuelve la cedula de la persona
     */
    public Persona getPersonaCedula(String cedula) { 
       Persona p = null;
       try {
           Query q = getManager().createQuery("SELECT p FROM Persona p where p.cedula = :ced");
           q.setParameter("ced", cedula);
           p = (Persona)q.getSingleResult();
       } catch (Exception e) {
       }
       return p;
   } 
}
