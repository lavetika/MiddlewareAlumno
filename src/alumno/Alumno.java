/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

import java.util.HashMap;

/**
 *
 * @author laura
 */
public class Alumno {

    public String nombre;
    public String carrera;
    public String id;

    public Alumno(String nombre, String carrera, String id) {
        this.nombre = nombre;
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


    
    
    
}
