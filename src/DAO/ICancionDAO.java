/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Canciones;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Ricardo
 */
public interface ICancionDAO extends IDAO<Canciones, Integer> {
     JasperPrint generarReporte() throws JRException;
}
