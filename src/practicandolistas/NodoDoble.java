/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicandolistas;

public class NodoDoble {
    private int dato;
    NodoDoble sgte;
    NodoDoble ant;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoDoble getSgte() {
        return sgte;
    }

    public void setSgte(NodoDoble sgte) {
        this.sgte = sgte;
    }

    public NodoDoble getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble ant) {
        this.ant = ant;
    }
    
}
