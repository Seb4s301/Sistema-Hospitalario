/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Jean
 */
public class HistorialClinico {
    private String dniPaciente; // Enlace directo con el DNI del Paciente
    private String tipoSangre;
    private String alergias;
    private String enfermedadesCronicas;
    private String observacionesMedicas;

    public HistorialClinico(String dniPaciente, String tipoSangre, String alergias, String enfermedadesCronicas, String observacionesMedicas) {
        this.dniPaciente = dniPaciente;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.observacionesMedicas = observacionesMedicas;
    }

    public String getDniPaciente() { return dniPaciente; }
    public void setDniPaciente(String dniPaciente) { this.dniPaciente = dniPaciente; }
    public String getTipoSangre() { return tipoSangre; }
    public void setTipoSangre(String tipoSangre) { this.tipoSangre = tipoSangre; }
    public String getAlergias() { return alergias; }
    public void setAlergias(String allergies) { this.alergias = allergies; }
    public String getEnfermedadesCronicas() { return enfermedadesCronicas; }
    public void setEnfermedadesCronicas(String enf) { this.enfermedadesCronicas = enf; }
    public String getObservacionesMedicas() { return observacionesMedicas; }
    public void setObservacionesMedicas(String obs) { this.observacionesMedicas = obs; }
}