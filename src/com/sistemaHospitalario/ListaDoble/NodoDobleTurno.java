package com.sistemaHospitalario.ListaDoble;

import sistema.hospitalario.Doctor.Turno;

/**
 *
 * @authores Sebastian Casavilca, 
 */
public class NodoDobleTurno {
    private Turno turno;
    private NodoDobleTurno siguiente;
    private NodoDobleTurno anterior;

    public NodoDobleTurno(Turno turno) {
        this.turno = turno;
        this.siguiente = null;
        this.anterior = null;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public NodoDobleTurno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDobleTurno siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDobleTurno getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDobleTurno anterior) {
        this.anterior = anterior;
    }

    
    
    
    
    
}
