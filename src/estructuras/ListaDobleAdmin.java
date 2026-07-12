package estructuras;

import modelos.Admin;
import nodos.NodoAdmin;

public class ListaDobleAdmin {
    private NodoAdmin ini;
    private NodoAdmin fin;
    private static ListaDobleAdmin instancia;

    private ListaDobleAdmin() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleAdmin getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleAdmin();
        }
        return instancia;
    }

    public void insertar(Admin dato) {
        NodoAdmin nuevo = new NodoAdmin(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public Admin buscar(String dni) {
        NodoAdmin actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public Admin buscarPorCodigo(String codigo) {
        NodoAdmin actual = ini;
        while (actual != null) {
            if (actual.getDato().getCodigo().equals(codigo)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(Admin adminModificado) {
        NodoAdmin actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(adminModificado.getDni())) {
                actual.setDato(adminModificado);
                return true;
            }
            actual = actual.getSgte();
        }
        return false;
    }

    public boolean eliminar(String dni) {
        NodoAdmin actual = ini;
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

    public java.util.ArrayList<modelos.Admin> obtenerTodos() {
        java.util.ArrayList<modelos.Admin> listaExportada = new java.util.ArrayList<>();
        NodoAdmin actual = ini;
        while (actual != null) {
            listaExportada.add(actual.getDato());
            actual = actual.getSgte();
        }
        return listaExportada;
    }
}