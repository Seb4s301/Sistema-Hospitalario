package modelos;

import java.util.Date;

public class Medico {
    private String codigo;
    private String nombres;
    private String apellidos;
    private Date turno;
    private String celular;
    private String especialidad;

    public Medico() {
        this.codigo = "";
        this.nombres = "";
        this.apellidos = "";
        this.turno = new Date();
        this.celular = "";
        this.especialidad = "";
    }

    public Medico(String codigo, String nombres, String apellidos, Date turno, String celular, String especialidad) {
        this.codigo = "M" + codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.turno = turno;
        this.celular = celular;
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = "M" + codigo;
    }

    public String getDni() {
        return codigo.replace("M", "");
    }

    public void setDni(String dni) {
        this.codigo = "M" + dni;
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