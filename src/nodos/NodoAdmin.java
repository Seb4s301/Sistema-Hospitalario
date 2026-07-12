package nodos;

import modelos.Admin;

public class NodoAdmin {
    private Admin dato;
    private NodoAdmin sgte;
    private NodoAdmin ant;

    public NodoAdmin(Admin dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Admin getDato() {
        return dato;
    }

    public void setDato(Admin dato) {
        this.dato = dato;
    }

    public NodoAdmin getSgte() {
        return sgte;
    }

    public void setSgte(NodoAdmin sgte) {
        this.sgte = sgte;
    }

    public NodoAdmin getAnt() {
        return ant;
    }

    public void setAnt(NodoAdmin ant) {
        this.ant = ant;
    }
}