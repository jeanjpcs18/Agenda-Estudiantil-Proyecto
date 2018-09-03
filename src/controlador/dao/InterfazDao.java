/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.List;

/**
 * una interfaz simplemente va a tener los metodos genericos 
 * Usar el metodo generico T, Debemos especificar que es una interfaz, son metodos sin cuerpo
 * @author Jean Pierre
 * @param <T> 
 */
public interface InterfazDao <T> {
    public void guardar(T obj) throws Exception;
    public void modificar(T obj) throws Exception;
    public List<T> listar();
    public T obtener(Long id);    
}
