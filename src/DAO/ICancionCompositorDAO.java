/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.CancionCompositor;
import Modelo.Canciones;
import Modelo.Compositor;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public interface ICancionCompositorDAO extends IDAO<CancionCompositor, Integer> {
    List<Compositor> obtenerCompositoresPorCancion(int idCancion)throws DAOException;
    
    List<Canciones> obtenerCancionesPorCompositor(int idCompositor)throws DAOException;
    
    void eliminar(CancionCompositor a)throws DAOException;
}
