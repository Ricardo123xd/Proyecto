/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

/**
 *
 * @author Ricardo
 */
public interface DAOManager {
    
    ICompositorDAO getCompositorDAO();
    ICancionDAO getCancionDAO();
    ICancionCompositorDAO getCancionCompositorDAO();
}
