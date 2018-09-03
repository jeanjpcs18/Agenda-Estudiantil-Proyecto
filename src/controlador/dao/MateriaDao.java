/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.utilidades.Sesion;
import controlador.utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import modelo.Materia;

/**
 *
 * @author Jean Pierre
 */
public class MateriaDao extends AdaptadorDao<Materia> {
    private Materia materia;
    /**
     * 
     */
    public MateriaDao() {
        super(Materia.class);        
    }
    /**
    * Metodo get que devuelve un dato materia
    * @return 
     */
    public Materia getMateria() {
        if(materia == null)
            materia = new Materia();
        return materia;
    }
    /**
    * Metodo set que tiene como parametro materia
    *  @param materia 
    */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    /**
     * Metodo que permite guardar y modificar una materia que
     * devuelve un boolean
     * @return 
     */
    public boolean guardar() {
        boolean verificar = false;
        try {
            String descripcion = "";
            String accion = "";
            getManager().getTransaction().begin();
            if(materia.getId() != null) {
                modificar(materia);
                descripcion = "Se modifica el materia "+materia.getId().intValue();
                accion = "Modificar Materia";
            } else {
                guardar(materia);
                descripcion = "Se registra una nueva materia";
                accion = "Guardar Materia";
            }
            getManager().getTransaction().commit();
            verificar = true;
        } catch (Exception e) {
            System.out.println("No se ha podido registrar o modificar" + e);
        }
        return verificar;
    }
    
    public List<Materia> listarMateria(){
        List<Materia> lista = new ArrayList();
        try {
            Query q = getManager().createQuery("SELECT p FROM Materia p where p.persona.id = :id");
            q.setParameter("id", Sesion.getCuenta().getPersona().getId());
            lista =  q.getResultList();
        } catch (Exception e) {
            System.out.println("error "+e);
        }
        return lista;
    }
    /**
     * Metodo listar materia con parametro id
     * @param id
     * @return nos devuelve la lista de las materias de un usuario
     */
    public List<Materia> listarMateriaNombre(Long id){
        List<Materia> lista = new ArrayList();
        try {
            Query q = getManager().createQuery("SELECT p FROM Materia p where p.persona.id = :id");
            q.setParameter("id", id); 
             lista =  q.getResultList();
        } catch (Exception e) {
//            System.out.println("error asdasd"+e);
            e.printStackTrace();
        }
        return lista;
    }      
}