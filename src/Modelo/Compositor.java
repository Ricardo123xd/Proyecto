/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ricardo
 */
public class Compositor {
    
    //campos o propiedades
    private int idcompositor;//clave primaria
    private String nombrecompleto;
    private int edad;
    private Set canciones = new HashSet(0);
    
    public Set getCanciones(){
        return this.canciones;
    }
    
    public void setCanciones(Set canciones){
        this.canciones = canciones;
    }
    
    public Compositor(){
        super();
    }

    public Compositor(String nombrecompleto, int edad){
        super();
        this.setNombre(nombrecompleto);
        this.setEdad(edad);
    }
    
    public Compositor(int idcompositor, String nombrecompleto, int edad) {
        super();
        this.setIdCompositor(idcompositor);
        this.setNombre(nombrecompleto);
        this.setEdad(edad);
    }

    public int getIdCompositor() {
        return idcompositor;
    }

    public void setIdCompositor(int idCompositor) {
        this.idcompositor = idCompositor;
    }

    public String getNombre() {
        return nombrecompleto;
    }

    public void setNombre(String nombre) {
        this.nombrecompleto = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return this.getNombre();
    }
}
