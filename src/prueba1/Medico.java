/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Jean
 */
import java.util.Date;

public class Medico {
    private String dni;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String celular;
    private String seguro;
    private String especialidad; // Se asigna desde el arreglo de especialidades global

    public Medico(String dni, String nombres, String apellidos, Date fechaNacimiento, String celular, String seguro, String especialidad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.seguro = seguro;
        this.especialidad = especialidad;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    public String getSeguro() { return seguro; }
    public void setSeguro(String seguro) { this.seguro = seguro; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String Black) { this.especialidad = especialidad; }
}