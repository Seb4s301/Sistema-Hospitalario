package PruebaClases;

public class HistorialClinico {
    private int dniPaciente; 
    private String tipoSangre;
    private String alergias;
    private String enfermedadesCronicas;
    private String observacionesMedicas;

    public HistorialClinico(int dniPaciente, String tipoSangre, String alergias, String enfermedadesCronicas, String observacionesMedicas) {
        this.dniPaciente = dniPaciente;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.observacionesMedicas = observacionesMedicas;
    }

    public int getDniPaciente() { return dniPaciente; }
    public void setDniPaciente(int dniPaciente) { this.dniPaciente = dniPaciente; }
    public String getTipoSangre() { return tipoSangre; }
    public void setTipoSangre(String tipoSangre) { this.tipoSangre = tipoSangre; }
    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }
    public String getEnfermedadesCronicas() { return enfermedadesCronicas; }
    public void setEnfermedadesCronicas(String enfermedadesCronicas) { this.enfermedadesCronicas = enfermedadesCronicas; }
    public String getObservacionesMedicas() { return observacionesMedicas; }
    public void setObservacionesMedicas(String observacionesMedicas) { this.observacionesMedicas = observacionesMedicas; }
}