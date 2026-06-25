
package Arbol;

import Clases.Medico;

public class NodoArbolMedico {
    private Medico dato;
    private NodoArbolMedico izq;
    private NodoArbolMedico der;
    
    public NodoArbolMedico(Medico dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public Medico getDato() {
        return dato;
    }

    public void setDato(Medico dato) {
        this.dato = dato;
    }

    public NodoArbolMedico getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolMedico izq) {
        this.izq = izq;
    }

    public NodoArbolMedico getDer() {
        return der;
    }

    public void setDer(NodoArbolMedico der) {
        this.der = der;
    }

    @Override
    public String toString() {
        return " " + dato;
    }
  
}
