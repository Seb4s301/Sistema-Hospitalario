
package estructuras;

import java.util.ArrayList;
import modelos.ReporteMedico;
import nodos.NodoReporte;

public class ListaDobleReporte {
    private NodoReporte ini;
    private NodoReporte fin;
    private static ListaDobleReporte instancia;

    private ListaDobleReporte() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleReporte getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleReporte();
        }
        return instancia;
    }

    public void insertar(ReporteMedico dato) {
        NodoReporte nuevo = new NodoReporte(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public ReporteMedico buscar(String dniPaciente) {
        NodoReporte actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(dniPaciente)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(ReporteMedico reporteModificado) {
        NodoReporte actual = ini;
        while (actual != null) {
            if (actual.getDato().getDniPaciente().equals(reporteModificado.getDniPaciente())) {
                actual.setDato(reporteModificado);
                return true;
            }
            actual = actual.getSgte();
        }
        return false;
    }

    public boolean eliminar(String dniPaciente) {
        NodoReporte actual = ini;
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

    public ArrayList<ReporteMedico> obtenerTodos() {
        ArrayList<ReporteMedico> lista = new ArrayList<>();
        NodoReporte actual = ini;
        while (actual != null) {
            lista.add(actual.getDato());
            actual = actual.getSgte();
        }
        return lista;
    }
}
