/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import DAO.DAOException;
import DAO.ICancionCompositorDAO;
import Modelo.Canciones;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ricardo
 */
public class CancionesTableModel extends AbstractTableModel {
    //crear un objeto de tipo ICancionCompositorDAO
    private ICancionCompositorDAO CancionCompositor;
    //crear una arrayList tipo Canciones
    private List<Canciones> datos = new ArrayList<>();
    
    //constructor que recibe un parametro  y asigna cancionCompositor
    public CancionesTableModel(ICancionCompositorDAO cancionCompositor){
        this.CancionCompositor = cancionCompositor;
    }
    
    //obtener el nombre de cada columna 
    public String getColumnName(int column){
        switch ( column ){
            case 0: return "Id Cancion";
            case 1: return "Nombre";
            case 2: return "Fecha de Creación";
            case 3: return "Duracion";
            default: return "[no]";
        }
    }

    //obtener la cantidad de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //obtener la cantidad de columnas
    @Override
    public int getColumnCount() {
        return 4;
    }

    //obtener el valor dentro de la fila y columna especificada
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Canciones preguntado = datos.get(rowIndex);
        switch( columnIndex ){
            case 0: return preguntado.getIdCancion();
            case 1: return preguntado.getNombre();
            case 2: return preguntado.getFechaCreacion();
            case 3: return preguntado.getDuracion();
            default:
                return "";
        }
    }
    //actualizar modelo
    public void updateModel(int idCompositor)throws DAOException{
        this.datos = CancionCompositor.obtenerCancionesPorCompositor(idCompositor);
    }
    
}
