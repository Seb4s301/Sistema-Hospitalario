package modelos;

import java.util.Date;

public class Recepcionista {
    private String codigo;
    private String nombres;
    private String apellidos;
    private Date fechaIngreso;
    private String celular;
    private String turno;

    public Recepcionista() {
        this.codigo = "";
        this.nombres = "";
        this.apellidos = "";
        this.fechaIngreso = new Date();
        this.celular = "";
        this.turno = "";
    }

    public Recepcionista(String dni, String nombres, String apellidos, Date fechaIngreso, String celular, String turno) {
        this.codigo = "R" + dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaIngreso = fechaIngreso;
        this.celular = celular;
        this.turno = turno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.startsWith("R")) {
            this.codigo = "R" + codigo;
        } else {
            this.codigo = codigo;
        }
    }

    public String getDni() {
        return codigo.substring(1);
    }

    public void setDni(String dni) {
        this.codigo = "R" + dni;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}