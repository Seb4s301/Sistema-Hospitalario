package nodos;

import modelos.HistorialClinico;

public class NodoHistorial {
    private HistorialClinico dato;
    private NodoHistorial sgte;
    private NodoHistorial ant;

    public NodoHistorial(HistorialClinico dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public HistorialClinico getDato() {
        return dato;
    }

    public void setDato(HistorialClinico dato) {
        this.dato = dato;
    }

    public NodoHistorial getSgte() {
        return sgte;
    }

    public void setSgte(NodoHistorial sgte) {
        this.sgte = sgte;
    }

    public NodoHistorial getAnt() {
        return ant;
    }

    public void setAnt(NodoHistorial ant) {
        this.ant = ant;
    }
}