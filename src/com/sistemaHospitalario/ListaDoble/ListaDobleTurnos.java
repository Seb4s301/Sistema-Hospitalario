package com.sistemaHospitalario.ListaDoble;

import sistema.hospitalario.Doctor.Turno;

/**
 * @author Sebastian Casavilca
 */
public class ListaDobleTurnos {
    private NodoDobleTurno inicio;
    private NodoDobleTurno fin;

    public ListaDobleTurnos() {
        this.inicio = null;
        this.fin = null;
    }
    
    public void agregar(Turno turno) {
        NodoDobleTurno nuevoNodo = new NodoDobleTurno(turno);
        
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
        }
    }
    
    
}
