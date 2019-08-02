/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Estudiante implements Serializable {
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;
    
    public Estudiante(String nombre, double nota1, double nota2, double nota3){
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.promedio = nota1+ nota2+ nota3 /3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", promedio=" + promedio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.nota1) ^ (Double.doubleToLongBits(this.nota1) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.nota2) ^ (Double.doubleToLongBits(this.nota2) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.nota3) ^ (Double.doubleToLongBits(this.nota3) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.promedio) ^ (Double.doubleToLongBits(this.promedio) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota1) != Double.doubleToLongBits(other.nota1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota2) != Double.doubleToLongBits(other.nota2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota3) != Double.doubleToLongBits(other.nota3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.promedio) != Double.doubleToLongBits(other.promedio)) {
            return false;
        }
        return true;
    }
    
    
    
}
