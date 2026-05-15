
package sistema.hospitalario;

import java.util.Date;

/**
 *
 * @author Sebas301
 */
public class Historiales {
    private Date fechaIngreso;
    private String paciente;
    private String dniPaciente;

    public Historiales(Date fechaIngreso, String paciente, String dniPaciente) {
        this.fechaIngreso = fechaIngreso;
        this.paciente = paciente;
        this.dniPaciente = dniPaciente;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }
    
    
}
