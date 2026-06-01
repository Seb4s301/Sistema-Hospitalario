package PruebaClases;


public class Medico {
    private String dni;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String celular;
    private String especialidad;

    public Medico() {
        this.dni = "";
        this.nombres = "";
        this.apellidos = "";
        this.fechaNacimiento = "";
        this.celular = "";
        this.especialidad = "";
    }

    public Medico(String dni, String nombres, String apellidos, String fechaNacimiento, String celular, String especialidad) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
}