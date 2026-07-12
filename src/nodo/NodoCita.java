package nodo;

import modelos.Cita;

public class NodoCita {
    private Cita dato;
    private NodoCita sgte;
    private NodoCita ant;

    public NodoCita(Cita dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Cita getDato() {
        return dato;
    }

    public void setDato(Cita dato) {
        this.dato = dato;
    }

    public NodoCita getSgte() {
        return sgte;
    }

    public void setSgte(NodoCita sgte) {
        this.sgte = sgte;
    }

    public NodoCita getAnt() {
        return ant;
    }

    public void setAnt(NodoCita ant) {
        this.ant = ant;
    }
    
}