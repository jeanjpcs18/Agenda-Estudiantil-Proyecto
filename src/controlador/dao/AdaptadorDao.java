/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.Conexion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *Clase que va a implementar los elementos de la interfaz 
 * @author Jean Pierre
 */
public class AdaptadorDao<T> implements InterfazDao<T> {

    
    private Class clazz;    
/**
 * Constructor de la clase, que tiene como parametro clazz
 * @param clazz 
 */
    public AdaptadorDao(Class clazz) {
    
        this.clazz = clazz;        
    }
   /**
    * Metodo get
    * @return devuelve la conexcion de la base de datos
    */
    public EntityManager getManager() {
        return Conexion.getManager();
    }
    /**
     * Metodo listar  
     * @return nos devuelve toda la lista
     */
    @Override
    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        try {
            Query query = getManager().createQuery("SELECT a FROM " + clazz.getSimpleName() + " a");
            lista = query.getResultList();
            
        } catch (Exception e) {            
            System.out.println("Error al listar datos " + e);
        }
        return lista;
    }
    /**
    * el metodo guardar tiene como parametro un tipo de dato generico T 
    * @param obj
    * @throws Exception 
    */
    @Override
    public void guardar(T obj) throws Exception {
        getManager().persist(obj);
    }
    /**
     * el metodo modificar tiene como parametro un tipo de dato generico T
     * @param obj
     * @throws Exception 
     */
    @Override
    public void modificar(T obj) throws Exception {
        getManager().merge(obj);
    }
    /**
     * permite obtener el id para identificar
     * @param id
     * @return nos devuelve la id identificada
     */
    @Override
    public T obtener(Long id) {
        T obj = null;
        try {
            obj = (T)getManager().find(clazz, id);
        } catch (Exception e) {
            System.out.println("No se encuentar el identificador id " + e);
        }
        return obj;
    }

}
