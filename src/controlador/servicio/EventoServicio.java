/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.EventosDao;
import java.util.List;
import modelo.Eventos;

/**
 *
 * @author Jean Pierre
 */
public class EventoServicio {
    private EventosDao obj = new EventosDao();
    /**
     * Metodo get  
     * @return nos devuelve el evento
     */
    public Eventos getEventos() {
        return obj.getEventos();
    }
    /**
     * Metodo guardar
     * @return nos devuelve el evento guardado
     */
    public boolean guardar() {
        return obj.guardar();
    }
    /**
     * Metodo todos
     * @return nos devuelve toda la lista de los eventos
     */
    public List<Eventos> todos() {
        return obj.listar();
    }
    /**
     * Metodo obtener id
     * @param id
     * @return 
     */
    public Eventos obtener(Long id) {
        return obj.obtener(id);
    }
    /**
     * Metodo que permite fijar el evento, como parametro evento 
     * @param eventos 
     */
    public void fijarEventos(Eventos eventos) {
        obj.setEventos(eventos);
    }
    /**
     * Metodo que nos devuelve la lista de los eventos por nombre de la materia.
     * @param nombre
     * @return 
     */
    public List<Eventos> listaEventosNombre(String nombre){
         return obj.listaEventosNombre(nombre);
    }    
}
