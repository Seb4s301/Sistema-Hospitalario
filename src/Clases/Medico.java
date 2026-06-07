package Clases;

import java.util.Date;


public class Medico {
    private String dni;
    private String nombres;
    private String apellidos;
    private Date turno;
    private String celular;
    private String especialidad;

    public Medico() {
        this.dni = "";
        this.nombres = "";
        this.apellidos = "";
        this.turno = new Date();
        this.celular = "";
        this.especialidad = "";
    }

    public Medico(String dni, String nombres, String apellidos, Date turno, String celular, String especialidad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.turno = turno;
        this.celular = celular;
        this.especialidad = especialidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getTurno() {
        return turno;
    }

    public void setTurno(Date turno) {
        this.turno = turno;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
}