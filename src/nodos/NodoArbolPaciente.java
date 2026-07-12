package nodos;

import modelos.Paciente;

public class NodoArbolPaciente {
    private Paciente dato;
    private NodoArbolPaciente izq;
    private NodoArbolPaciente der;

    public NodoArbolPaciente(Paciente dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public NodoArbolPaciente getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolPaciente izq) {
        this.izq = izq;
    }

    public NodoArbolPaciente getDer() {
        return der;
    }

    public void setDer(NodoArbolPaciente der) {
        this.der = der;
    }
}