
package PruebaNodo;

import PruebaClases.Medico;

import PruebaLista.ListaDobleMedico;
import PruebaClases.Medico;

public class NodoMedico {
    Medico dato;
    NodoMedico sgte;
    NodoMedico ant;

    public NodoMedico(Medico dato) {
        this.dato = dato;
        sgte=ant=null;
    }
    
    public NodoMedico() {
        this.dato = new Medico();
        sgte=ant=null;
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
