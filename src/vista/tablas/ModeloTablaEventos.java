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
import modelo.Eventos;

/**
 *
 * @author Jean Pierre
 */
public class ModeloTablaEventos extends AbstractTableModel{
    @Setter
    @Getter
    
    private List<Eventos> listaEven = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listaEven.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Eventos evento = listaEven.get(rowIndex);
        switch(columnIndex) {
            case 0: return evento.getDescripcion();
            case 1: return evento.getFechaInicio();
            case 2: return evento.getFechaFinalizacion();
            case 3: return evento.getTipo().toString();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Descripcion";
            case 1: return "Fecha Inicio";
            case 2: return "Fecha Finalizacion";
            case 3: return "Tipo de Evento";
            default: return null;
        }
    }
}