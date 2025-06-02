/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ricardo
 */
public class CancionCompositor {
    private int idCancion;
    private int idCompositor;

    //constructor vacío
    public CancionCompositor() {
    }
    
    //constructor con dos parametros donde se pasa primero idCancion
    public CancionCompositor(int idCancion, int idCompositor){
        this.setIdCancion(idCancion);
        this.setIdCompositor(idCompositor);
    }
    
    //getters y setters
    
    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public int getIdCompositor() {
        return idCompositor;
    }

    public void setIdCompositor(int idCompositor) {
        this.idCompositor = idCompositor;
    }
    
    
}
