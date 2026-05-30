package HorariosHospital_desarrollando;

import PruebaLista.ListaDobleTurno;
import java.time.LocalTime;

public class Doctor {
    
    enum DiaSemana { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
    enum EstadoMedico { ACTIVO, INACTIVO, VACACIONES }
    
    public class Turno {
    
    enum DiaSemana { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
    
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Turno(DiaSemana dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
}
    
    private String codigo, nombres, especialidad;
    private String numeroCMP, telefono;
    private EstadoMedico estado;
    private ListaDobleTurno horarios; 

    public Doctor(String nombres, String especialidad, ListaDobleTurno horarios) {
        this.nombres = nombres;
        this.especialidad = especialidad;
        this.horarios = new ListaDobleTurno();
    }
    
            
            
}
