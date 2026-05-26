/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicandolistas;

/**
 *
 * @author Jean
 */
public class NodoPersona {
    Persona dato;
    NodoPersona sgte;
    NodoPersona ant;

    public NodoPersona(Persona dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public NodoPersona getSgte() {
        return sgte;
    }

    public void setSgte(NodoPersona sgte) {
        this.sgte = sgte;
    }

    public NodoPersona getAnt() {
        return ant;
    }

    public void setAnt(NodoPersona ant) {
        this.ant = ant;
    }
    
    
    
}
