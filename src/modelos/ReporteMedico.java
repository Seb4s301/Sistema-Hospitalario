
package modelos;

import java.util.Date;

public class ReporteMedico {
    private String dniPaciente;
    private String dniMedico;
    private String sintomas;
    private String alergias;
    private String enfermedades;
    private String tratamiento;
    private String observaciones;
    private Date fecha;

    public ReporteMedico() {}

    public ReporteMedico(String dniPaciente, String dniMedico, String sintomas, String alergias, String enfermedades, String tratamiento, String observaciones, Date fecha) {
        this.dniPaciente = dniPaciente;
        this.dniMedico = dniMedico;
        this.sintomas = sintomas;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.fecha = fecha;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getDniMedico() {
        return dniMedico;
    }

    public void setDniMedico(String dniMedico) {
        this.dniMedico = dniMedico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
