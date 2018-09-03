/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lombok.Getter;
import lombok.Setter;
import modelo.Materia;

/**
 *
 * @author Jean Pierre
 */
public class ModeloTablaMateria extends AbstractTableModel{
    @Setter
    @Getter
    
    private List<Materia> listaMat = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaMat.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Materia materia = listaMat.get(rowIndex);
        switch(columnIndex) {
            case 0: return materia.getNombreMateria();
            case 1: return materia.getCreditos();
            case 2: return materia.getNombreProfesor(); 
            default: return null;
        }
    }
    
    public Materia getValueAt(int rowIndex){
        return listaMat.get(rowIndex);
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Materia";
            case 1: return "Creditos ";
            case 2: return "Profesor";
            default: return null;
        }
    }
}
