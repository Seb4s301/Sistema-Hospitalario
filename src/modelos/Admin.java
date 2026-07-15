package modelos;

import java.util.Date;

public class Admin {
    private String codigo;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private String celular;
    private String cargo;

    public Admin() {
        this.codigo = "";
        this.nombres = "";
        this.apellidos = "";
        this.fechaIngreso = new Date();
        this.celular = "";
        this.cargo = "Administrador";
    }

    public Admin(String codigo, String nombres, String apellidos, Date fechaIngreso, String celular, String cargo) {
        this.codigo = "A" + codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.celular = celular;
        this.cargo = cargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.startsWith("A")) {
            this.codigo = "A" + codigo;
        } else {
            this.codigo = codigo;
        }
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDni() {
        return codigo.substring(1);
    }
}