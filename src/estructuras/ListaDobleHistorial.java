package estructuras;

import modelos.HistorialClinico;
import nodos.NodoHistorial;

public class ListaDobleHistorial {
    private NodoHistorial ini;
    private NodoHistorial fin;
    private static ListaDobleHistorial instancia;

    private ListaDobleHistorial() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleHistorial getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleHistorial();
        }
        return instancia;
    }

    public void insertar(HistorialClinico dato) {
        NodoHistorial nuevo = new NodoHistorial(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public HistorialClinico buscar(String dniPaciente) {
        NodoHistorial actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(dniPaciente)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(HistorialClinico historialModificado) {
        NodoHistorial actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(historialModificado.getDniPaciente())) {
                actual.setDato(historialModificado);
                return true; 
            }
            actual = actual.getSgte();
        }
        return false; 
    }

    public boolean eliminar(String dniPaciente) {
        NodoHistorial actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(dniPaciente)) {
                
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
}