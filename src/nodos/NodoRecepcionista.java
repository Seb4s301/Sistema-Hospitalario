package nodos;

import modelos.Recepcionista;

public class NodoRecepcionista {
    private Recepcionista dato;
    private NodoRecepcionista sgte;
    private NodoRecepcionista ant;

    public NodoRecepcionista(Recepcionista dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Recepcionista getDato() {
        return dato;
    }

    public void setDato(Recepcionista dato) {
        this.dato = dato;
    }

    public NodoRecepcionista getSgte() {
        return sgte;
    }

    public void setSgte(NodoRecepcionista sgte) {
        this.sgte = sgte;
    }

    public NodoRecepcionista getAnt() {
        return ant;
    }

    public void setAnt(NodoRecepcionista ant) {
        this.ant = ant;
    }
}