package PruebaNodo;

import PruebaLista.ListaDobleTurno;

/**
 *
 * @author sebastian
 */
public class NodoTurno {
    NodoTurno nodo;
    ListaDobleTurno sgnt; 
    ListaDobleTurno ant;

    public NodoTurno(NodoTurno nodo) {
        this.nodo = nodo;
        sgnt = ant = null;
    }

    public NodoTurno getNodo() {
        return nodo;
    }

    public void setNodo(NodoTurno nodo) {
        this.nodo = nodo;
    }

    public ListaDobleTurno getSgnt() {
        return sgnt;
    }

    public void setSgnt(ListaDobleTurno sgnt) {
        this.sgnt = sgnt;
    }

    public ListaDobleTurno getAnt() {
        return ant;
    }

    public void setAnt(ListaDobleTurno ant) {
        this.ant = ant;
    }
    
    
    
}
