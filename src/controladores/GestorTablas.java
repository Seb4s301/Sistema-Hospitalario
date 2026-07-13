package controladores;

import modelos.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class GestorTablas {
    private final SimpleDateFormat formatoFechaNac = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat formatoTurno = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public DefaultTableModel modeloTablaPacientes(ArrayList<Paciente> lista) {
        String[] columnas = {"DNI", "Nombres", "Apellidos", "Fecha Nac.", "Celular", "Seguro"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (Paciente p : lista) {
            String fechaFormateada = (p.getFechaNacimiento() != null) ? formatoFechaNac.format(p.getFechaNacimiento()) : "";
            
            modelo.addRow(new Object[]{
                p.getDni(), 
                p.getNombres(), 
                p.getApellidos(), 
                fechaFormateada, 
                p.getCelular(), 
                p.getSeguro()
            });
        }
        return modelo;
    }
    
    public DefaultTableModel modeloTablaMedicos(ArrayList<Medico> lista) {
        String[] columnas = {"Código", "Nombres", "Apellidos", "Turno", "Celular", "Especialidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (Medico m : lista) {
            String turnoFormateado = (m.getTurno() != null) ? formatoTurno.format(m.getTurno()) : "";
            
            modelo.addRow(new Object[]{
                m.getDni(),
                m.getNombres(),
                m.getApellidos(),
                turnoFormateado,
                m.getCelular(),
                m.getEspecialidad()
            });
        }
        return modelo;
    }
    
    public DefaultTableModel modeloTablaCitas(ArrayList<Cita> lista) {
        String[] columnas = {"DNI Paciente", "Paciente", "Codigo Medico", "Medico", "Especialidad", "Fecha"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (Cita c : lista) {
            String fechaCita = (c.getFecha() != null) ? formatoTurno.format(c.getFecha()) : "";

            modelo.addRow(new Object[]{
                c.getDniPaciente(),
                c.getNombrePaciente() + " " + c.getApellidoPaciente(),
                c.getDniMedico(),
                c.getNombreMedico() + " " + c.getApellidoMedico(),
                c.getEspecialidad(),
                fechaCita
            });
        }
        return modelo;
    }
    
    public DefaultTableModel modeloTablaHistoriales(ArrayList<HistorialClinico> lista) {
        String[] columnas = {"DNI Paciente", "Tipo de sangre", "Alergias", "Enferm. Cronicas", "Observaciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (HistorialClinico h : lista) {
            modelo.addRow(new Object[]{
                h.getDniPaciente(), 
                h.getTipoSangre(), 
                h.getAlergias(), 
                h.getEnfermedadesCronicas(), 
                h.getObservacionesMedicas()
            });
        }
        return modelo;
    }

    public DefaultTableModel modeloTablaReportes(ArrayList<ReporteMedico> lista) {
        String[] columnas = {"DNI Paciente", "Sintomas", "Alergias", "Enfermedades", "Tratamiento", "Observaciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        for (ReporteMedico r : lista) {
            modelo.addRow(new Object[]{
                r.getDniPaciente(),
                r.getSintomas(),
                r.getAlergias(),
                r.getEnfermedades(),
                r.getTratamiento(),
                r.getObservaciones()
            });
        }
        return modelo;
    }
}
