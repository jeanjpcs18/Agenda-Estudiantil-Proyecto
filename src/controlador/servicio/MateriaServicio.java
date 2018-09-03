/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servicio;

import controlador.dao.MateriaDao;
import java.util.List;
import modelo.Materia;

/**
 *
 * @author Jean Pierre
 */
public class MateriaServicio {
    private MateriaDao obj = new MateriaDao();
    /**
     * Metodo get
     * @return nos devuelve una materia 
     */
    public Materia getMateria() {
        return obj.getMateria();
    }
    /**
     * Metodo guardar
     * @return nos devuelve la materia guardada
     */
    public boolean guardar() {
        return obj.guardar();
    }
    /**
     * Metodo listar
     * @return nos devuelve la lista de todas la materias 
     */
    public List<Materia> todos() {
        return obj.listar();
    }
    /**
     * Metodo obtener
     * @param id
     * @return nos devuelve la ide obtenida
     */
    public Materia obtener(Long id) {
        return obj.obtener(id);
    }
    /**
     * Metodo fijar que tiene como parametro materia
     * @param materia 
     */
    public void fijarMateria(Materia materia) {
        obj.setMateria(materia);
    }
       
    public List<Materia> listarMateria(){
        return obj.listarMateria();
    }
    /**
     * Metodo listar
     * @param id
     * @return nos devuelve todas las materias que tengo la misma id
     */
    public List<Materia> listarMateriaNombre(Long id){
         return obj.listarMateriaNombre(id);
    }

}
