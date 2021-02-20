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
    public String fechaNacimiento;
    public String id;
    HashMap<String, Integer> materias;

    public Alumno(String nombre, String carrera, String fechaNacimiento, String id, HashMap<String, Integer> materias) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.fechaNacimiento = fechaNacimiento;
        this.id = id;
        this.materias = materias;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Integer> getMaterias() {
        return materias;
    }

    public void setMaterias(HashMap<String, Integer> materias) {
        this.materias = materias;
    }
    
    
    
}
