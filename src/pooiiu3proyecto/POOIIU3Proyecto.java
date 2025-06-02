/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pooiiu3proyecto;

import Vista.JDCanciones;
import Vista.JDCompositores;

/**
 *
 * @author Ricardo
 */
public class POOIIU3Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //asignar titulo a JDCompositores
        JDCompositores misCompositores = new JDCompositores(null, true);
        misCompositores.setTitle("Gestion de Compositores");
        misCompositores.setLocationRelativeTo(null);
        misCompositores.setVisible(true);
        //asignar titulo a JDCanciones
        JDCanciones misCanciones = new JDCanciones(null, true);
        misCanciones.setTitle("Gestion de Canciones");
        misCanciones.setLocationRelativeTo(null);
        misCanciones.setVisible(true);
    }
    
}
