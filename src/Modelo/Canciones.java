/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ricardo
 */
public class Canciones {
    
    private int idCancion;
    private String nombre;
    private String fechaCreacion;
    private int duracion;

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Canciones() {
        super();
    }

    public Canciones(String nombre, String fechaCreacion, int duracion) {
        super();
        this.setNombre(nombre);
        this.setFechaCreacion(fechaCreacion);
        this.setDuracion(duracion);
    }

    public Canciones(int idCancion, String nombre, String fechaCreacion, int duracion) {
        this.setIdCancion(idCancion);
        this.setNombre(nombre);
        this.setFechaCreacion(fechaCreacion);
        this.setDuracion(duracion);
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
    
    
    
    
}
