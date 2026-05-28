/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Jean
 */
public class NodoMedico {
    Medico dato;
    NodoMedico sgte;
    NodoMedico ant;

    public NodoMedico(Medico dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Medico getDato() { return dato; }
    public void setDato(Medico dato) { this.dato = dato; }
    public NodoMedico getSgte() { return sgte; }
    public void setSgte(NodoMedico sgte) { this.sgte = sgte; }
    public NodoMedico getAnt() { return ant; }
    public void setAnt(NodoMedico ant) { this.ant = ant; }
}
