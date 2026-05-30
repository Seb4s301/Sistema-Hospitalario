package PruebaClases;

import java.util.Date;

public class Paciente {
    private String dni; 
    private String nombres;
    private String apellidos;
    private String fechaNacimiento; 
    private String celular;
    private String seguro;

    public Paciente() {
        dni="";
        nombres="";
        apellidos="";
        fechaNacimiento="";
        celular="";
        seguro="";
    }
    
    public Paciente(String dni, String nombres, String apellidos, String fechaNacimiento, String celular, String seguro) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.seguro = seguro;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    
}