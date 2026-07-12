package arbol;

import modelos.Paciente;
import nodos.NodoArbolPaciente;
import java.util.ArrayList;

public class ArbolPaciente {
    private NodoArbolPaciente raiz;
    private static ArbolPaciente instancia;

    private ArbolPaciente() {
        this.raiz = null;
    }

    public static ArbolPaciente getInstancia() {
        if (instancia == null) {
            instancia = new ArbolPaciente();
        }
        return instancia;
    }

    public NodoArbolPaciente getRaiz() {
        return raiz;
    }

    public void insertar(Paciente dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbolPaciente insertarRec(NodoArbolPaciente nodo, Paciente dato) {
        if (nodo == null) {
            return new NodoArbolPaciente(dato);
        }
        
        if (dato.getDni().compareTo(nodo.getDato().getDni()) < 0) {
            nodo.setIzq(insertarRec(nodo.getIzq(), dato));
        } else if (dato.getDni().compareTo(nodo.getDato().getDni()) > 0) {
            nodo.setDer(insertarRec(nodo.getDer(), dato));
        }
        
        return nodo;
    }

    public Paciente buscar(String dni) {
        NodoArbolPaciente resultado = buscarRec(raiz, dni);
        if (resultado != null) {
            return resultado.getDato();
        }
        return null;
    }

    private NodoArbolPaciente buscarRec(NodoArbolPaciente nodo, String dni) {
        if (nodo == null) return null;
        if (dni.compareTo(nodo.getDato().getDni()) == 0) return nodo;
        if (dni.compareTo(nodo.getDato().getDni()) < 0) return buscarRec(nodo.getIzq(), dni);
        
        return buscarRec(nodo.getDer(), dni);
    }

    public boolean modificar(Paciente pacienteModificado) {
        NodoArbolPaciente nodo = buscarRec(raiz, pacienteModificado.getDni());
        if (nodo != null) {
            nodo.setDato(pacienteModificado);
            return true;
        }
        return false;
    }

    public boolean eliminar(String dni) {
        if (buscar(dni) != null) {
            raiz = eliminarRec(raiz, dni);
            return true;
        }
        return false;
    }

    private NodoArbolPaciente eliminarRec(NodoArbolPaciente nodo, String dni) {
        if (nodo == null) return null;
        
        if (dni.compareTo(nodo.getDato().getDni()) < 0) {
            nodo.setIzq(eliminarRec(nodo.getIzq(), dni));
        } else if (dni.compareTo(nodo.getDato().getDni()) > 0) {
            nodo.setDer(eliminarRec(nodo.getDer(), dni));
        } else {
            if (nodo.getIzq() == null) return nodo.getDer();
            if (nodo.getDer() == null) return nodo.getIzq();
            
            NodoArbolPaciente sucesor = minimonodo(nodo.getDer());
            nodo.setDato(sucesor.getDato());
            nodo.setDer(eliminarRec(nodo.getDer(), sucesor.getDato().getDni()));
        }
        return nodo;
    }

    private NodoArbolPaciente minimonodo(NodoArbolPaciente nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo; 
    }

    public ArrayList<Paciente> obtenerTodos() {
        ArrayList<Paciente> listaExportada = new ArrayList<>();
        recorridoInOrden(raiz, listaExportada);
        return listaExportada;
    }

    private void recorridoInOrden(NodoArbolPaciente actual, ArrayList<Paciente> lista) {
        if (actual != null) {
            recorridoInOrden(actual.getIzq(), lista); 
            lista.add(actual.getDato());              
            recorridoInOrden(actual.getDer(), lista); 
        }
    }
}