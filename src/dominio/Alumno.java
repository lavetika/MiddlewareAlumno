/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author laura
 */
public class Alumno {
    public String nombre;
    public String carrera;
    public String id;

    public Alumno(String id, String nombre, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.id = id;
    }

    public Alumno(String id, String carrera) {
        this.carrera = carrera;
        this.id = id;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," + carrera;
    }    
}
