
package Nodo;

import Clases.Cita;

public class NodoAgendar {
    private Cita dato;
    private NodoAgendar sgte;
    private NodoAgendar ant;

    public NodoAgendar(Cita dato) {
        this.dato = dato;
        sgte = ant = null;
    }

    public NodoAgendar() {
        this.dato = new Cita();
        sgte = ant = null;
    }

    public Cita getDato() {
        return dato;
    }

    public void setDato(Cita dato) {
        this.dato = dato;
    }

    public NodoAgendar getSgte() {
        return sgte;
    }

    public void setSgte(NodoAgendar sgte) {
        this.sgte = sgte;
    }

    public NodoAgendar getAnt() {
        return ant;
    }

    public void setAnt(NodoAgendar ant) {
        this.ant = ant;
    }
}

