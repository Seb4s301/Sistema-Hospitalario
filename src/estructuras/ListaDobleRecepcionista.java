package estructuras;

import modelos.Recepcionista;
import nodos.NodoRecepcionista;

public class ListaDobleRecepcionista {
    private NodoRecepcionista ini;
    private NodoRecepcionista fin;
    private static ListaDobleRecepcionista instancia;

    private ListaDobleRecepcionista() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleRecepcionista getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleRecepcionista();
        }
        return instancia;
    }

    public void insertar(Recepcionista dato) {
        NodoRecepcionista nuevo = new NodoRecepcionista(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public Recepcionista buscarPorDni(String dni) {
        NodoRecepcionista actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public Recepcionista buscarPorCodigo(String codigo) {
        NodoRecepcionista actual = ini;
        while (actual != null) {
            if (actual.getDato().getCodigo().equals(codigo)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(Recepcionista recepcionistaModificado) {
        NodoRecepcionista actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(recepcionistaModificado.getDni())) {
                actual.setDato(recepcionistaModificado);
                return true;
            }
            actual = actual.getSgte();
        }
        return false;
    }

    public boolean eliminar(String dni) {
        NodoRecepcionista actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
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

    public java.util.ArrayList<modelos.Recepcionista> obtenerTodos() {
        java.util.ArrayList<modelos.Recepcionista> listaExportada = new java.util.ArrayList<>();
        NodoRecepcionista actual = ini;
        while (actual != null) {
            listaExportada.add(actual.getDato());
            actual = actual.getSgte();
        }
        return listaExportada;
    }
}