/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.crud_seminarios;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Estudiante {
    private int id;
    private String fecha;
    private String nombre;
    private String apellidos;
    private String turno;
    private ArrayList<String> seminarios;

    public Estudiante() {
        this.id = 0;
        this.fecha ="";
        this.nombre ="";
        this.apellidos ="";
        this.turno ="";
        this.seminarios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public ArrayList getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(ArrayList<String> seminarios) {
        this.seminarios = seminarios;
    }
    
    
    
}
