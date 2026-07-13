package estructuras;

import java.util.Date;
import modelos.Cita;
import nodos.NodoCita;

public class ListaDobleCita {
    private NodoCita ini;
    private NodoCita fin;
    private static ListaDobleCita instancia;

    private ListaDobleCita() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleCita getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleCita();
        }
        return instancia;
    }
    
    public void insertar(Cita dato) {
        NodoCita nuevo = new NodoCita(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }
    
    public Cita buscar(String dniPaciente, String especialidad) {
        NodoCita actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(dniPaciente) && 
                actual.getDato().getEspecialidad().equals(especialidad)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(Cita citaModificada) {
        NodoCita actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(citaModificada.getDniPaciente()) &&
                actual.getDato().getEspecialidad().equals(citaModificada.getEspecialidad())) {
                actual.setDato(citaModificada);
                return true; 
            }
            actual = actual.getSgte();
        }
        return false; 
    }

    public boolean eliminar(String dniPaciente, String especialidad) {
        NodoCita actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(dniPaciente) && 
                actual.getDato().getEspecialidad().equals(especialidad)) {
                
                if (actual == ini && actual == fin) {
                    ini = fin = null;
                } else if (actual == ini) {
                    ini = ini.getSgte();
                    ini.setAnt(null);
                } else if (actual == fin) {
                    fin = fin.getAnt();
                    fin.setSgte(null);
                } else {
                    actual.getAnt().setSgte(actual.getSgte());
                    actual.getSgte().setAnt(actual.getAnt());
                }
                return true; 
            }
            actual = actual.getSgte();
        }
        return false; 
    }
    
    public java.util.ArrayList<modelos.Cita> obtenerTodos() {
        java.util.ArrayList<modelos.Cita> listaExportada = new java.util.ArrayList<>();
        nodos.NodoCita actual = ini;
        
        while (actual != null) {
            listaExportada.add(actual.getDato());
            actual = actual.getSgte();
        }
        
        return listaExportada;
    }
    
    public boolean validarSeparacion15Minutos(String dniMedico, Date nuevaFecha) {
        if (nuevaFecha == null) return true;
        
        nodos.NodoCita actual = ini;
        while (actual != null) {
            Cita cita = actual.getDato();
            if (cita.getDniMedico().equals(dniMedico) && cita.getFecha() != null) {
                long diffMillis = Math.abs(nuevaFecha.getTime() - cita.getFecha().getTime());
                long diffMinutes = diffMillis / (60 * 1000);
                if (diffMinutes < 15) {
                    return false; // Hay una cita a menos de 15 minutos
                }
            }
            actual = actual.getSgte();
        }
        return true;
    }
}