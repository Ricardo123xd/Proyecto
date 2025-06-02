/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOManager;
import DAO.ICancionCompositorDAO;
import DAO.ICancionDAO;
import DAO.ICompositorDAO;

/**
 *
 * @author Ricardo
 */
public class MySQLDAOManager implements DAOManager{
    
    //variables para la base de datos
    private ICompositorDAO compositores = null;
    private ICancionDAO canciones = null;
    private ICancionCompositorDAO cancionCompositor = null;

    

    @Override
    public ICompositorDAO getCompositorDAO() {
        //si no existe entonces creamos uno nuevo
        if(compositores == null){
            compositores = new MySQLCompositorDAO();
        }
        return compositores;
    }

    @Override
    public ICancionDAO getCancionDAO() {
        if(canciones == null){
            canciones = new MySQLCancionDAO();
        }
        return canciones;
    }

    @Override
    public ICancionCompositorDAO getCancionCompositorDAO() {
        if(cancionCompositor == null){
            cancionCompositor = new MySQLCancionCompositorDAO();
        }
        return cancionCompositor;
    }
    
    
    
}
