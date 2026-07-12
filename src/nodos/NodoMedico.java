package nodos;

import modelos.Medico;

public class NodoMedico {
    private Medico dato;
    private NodoMedico sgte;
    private NodoMedico ant;

    public NodoMedico(Medico dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Medico getDato() {
        return dato;
    }

    public void setDato(Medico dato) {
        this.dato = dato;
    }

    public NodoMedico getSgte() {
        return sgte;
    }

    public void setSgte(NodoMedico sgte) {
        this.sgte = sgte;
    }

    public NodoMedico getAnt() {
        return ant;
    }

    public void setAnt(NodoMedico ant) {
        this.ant = ant;
    }  
}