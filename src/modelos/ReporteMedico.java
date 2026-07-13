
package modelos;

/**
 *
 * @author Usuario
 */
public class ReporteMedico {
    private String dniPaciente;
    private String sintomas;
    private String alergias;
    private String enfermedades;
    private String tratamiento;
    private String observaciones;

    public ReporteMedico() {}

    public ReporteMedico(String dniPaciente, String sintomas, String alergias, String enfermedades, String tratamiento, String observaciones) {
        this.dniPaciente = dniPaciente;
        this.sintomas = sintomas;
        this.alergias = alergias;
        this.enfermedades = enfermedades;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
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
    
    
}
