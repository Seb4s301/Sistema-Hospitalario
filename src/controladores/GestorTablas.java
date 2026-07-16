package controladores;

import modelos.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;

public class GestorTablas {
    public final SimpleDateFormat formatoFechaNac = new SimpleDateFormat("dd/MM/yyyy");
    public final SimpleDateFormat formatoTurno = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    public void asignarRenderersFechas(JTable tabla, int[] columnasFecha, SimpleDateFormat formato) {
        TableCellRenderer renderer = new TableCellRenderer() {
            private final SimpleDateFormat fmt = formato;
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                } else {
                    label.setBackground(table.getBackground());
                    label.setForeground(table.getForeground());
                }
                if (value instanceof Date) {
                    label.setText(fmt.format((Date) value));
                }
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        };
        for (int col : columnasFecha) {
            tabla.getColumnModel().getColumn(col).setCellRenderer(renderer);
        }
    }

    public DefaultTableModel modeloTablaPacientes(ArrayList<Paciente> lista) {
        String[] columnas = {"DNI", "Nombres", "Apellidos", "Fecha Nac.", "Celular", "Seguro"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        for (Paciente p : lista) {
            modelo.addRow(new Object[]{
                p.getDni(), 
                p.getNombres(), 
                p.getApellidos(), 
                p.getFechaNacimiento(),
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
            modelo.addRow(new Object[]{
                m.getCodigo(),
                m.getNombres(),
                m.getApellidos(),
                m.getTurno(),
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
            modelo.addRow(new Object[]{
                c.getDniPaciente(),
                c.getNombrePaciente() + " " + c.getApellidoPaciente(),
                c.getDniMedico(),
                c.getNombreMedico() + " " + c.getApellidoMedico(),
                c.getEspecialidad(),
                c.getFecha()
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
        String[] columnas = {"DNI Paciente", "Sintomas", "Alergias", "Enfermedades", "Tratamiento", "Observaciones", "Fecha"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (ReporteMedico r : lista) {
            modelo.addRow(new Object[]{
                r.getDniPaciente(),
                r.getSintomas(),
                r.getAlergias(),
                r.getEnfermedades(),
                r.getTratamiento(),
                r.getObservaciones(),
                r.getFecha() != null ? formatoTurno.format(r.getFecha()) : ""
            });
        }
        return modelo;
    }

    public DefaultTableModel modeloTablaHistorialCompleto(ArrayList<Cita> citas, ArrayList<ReporteMedico> reportes) {
        String[] columnas = {"Fecha", "Medico", "Especialidad", "Sintomas", "Enfermedades", "Tratamiento", "Observaciones"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));

        for (ReporteMedico r : reportes) {
            String fechaStr = r.getFecha() != null ? fmt.format(r.getFecha()) : "";
            String medico = "";
            String especialidad = "";

            for (Cita c : citas) {
                String codigoMedicoCita = c.getDniMedico();
                String dniMedicoCita = (codigoMedicoCita != null && codigoMedicoCita.length() > 1)
                        ? codigoMedicoCita.substring(1) : codigoMedicoCita;

                if (dniMedicoCita != null && dniMedicoCita.equals(r.getDniMedico())) {
                    medico = c.getNombreMedico() + " " + c.getApellidoMedico();
                    especialidad = c.getEspecialidad();
                    break;
                }
            }

            modelo.addRow(new Object[]{
                fechaStr,
                medico,
                especialidad,
                r.getSintomas(),
                r.getEnfermedades(),
                r.getTratamiento(),
                r.getObservaciones()
            });
        }
        return modelo;
    }
}
