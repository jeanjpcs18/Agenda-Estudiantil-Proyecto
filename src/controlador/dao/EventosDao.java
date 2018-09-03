/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.utilidades.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Eventos;

/**
 *
 * @author Jean Pierre
 */
public class EventosDao extends AdaptadorDao<Eventos> {
    private Eventos eventos;

    public EventosDao() {
        super(Eventos.class);        
    }
    /**
     * Metodo get que retorna un nuevo evento
     * @return 
     */
    public Eventos getEventos() {
        if(eventos == null)
            eventos = new Eventos();
        return eventos;
    }
    /**
     * Metodo set que tiene como parametro un evento
     * @param eventos 
     */
    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
    }
    /**
     * Metodo que permite guardar y modificar un evento que
     * devuelve un boolean
     * @return 
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            String descripcion = "";
            String accion = "";
            getManager().getTransaction().begin();
            if(eventos.getId() != null) {
                modificar(eventos);
                descripcion = "Se modifica el eventos "+eventos.getId().intValue();
                accion = "Modificar Eventos";
            } else {
                guardar(eventos);
                descripcion = "Se registra un nuevo eventos";
                accion = "Guardar Eventos";
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }
    
    /**
     * Permite listar todos los eventos 
     * @param nombre
     * @return nos devuelve la lista de los eventos por nobre de la materia.
     */
    public List<Eventos> listaEventosNombre(String nombre){
        List<Eventos> lista = new ArrayList();
        try {
            Query q = getManager().createQuery("SELECT p FROM Eventos p where p.materia.nombreMateria = :nombre");
            q.setParameter("nombre", nombre);
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
}
