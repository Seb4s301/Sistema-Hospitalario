
package Clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Cita {
    private String dniPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniMedico;
    private String nombreMedico;
    private String apellidoMedico;
    private String especialidad;
    private Date fecha;

    public Cita() {
    }

    public Cita(String dniPaciente, String nombrePaciente, String apellidoPaciente,
                 String dniMedico, String nombreMedico, String apellidoMedico,
                 String especialidad, Date fecha) {
        this.dniPaciente = dniPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.dniMedico = dniMedico;
        this.nombreMedico = nombreMedico;
        this.apellidoMedico = apellidoMedico;
        this.especialidad = especialidad;
        this.fecha = fecha;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public String getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(String dniMedico) {
        this.dniMedico = dniMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidoMedico() {
        return apellidoMedico;
    }

    public void setApellidoMedico(String apellidoMedico) {
        this.apellidoMedico = apellidoMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
