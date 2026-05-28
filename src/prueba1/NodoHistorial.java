/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Jean
 */
public class NodoHistorial {
    HistorialClinico dato;
    NodoHistorial sgte;
    NodoHistorial ant;

    public NodoHistorial(HistorialClinico dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public HistorialClinico getDato() { return dato; }
    public void setDato(HistorialClinico dato) { this.dato = dato; }
    public NodoHistorial getSgte() { return sgte; }
    public void setSgte(NodoHistorial sgte) { this.sgte = sgte; }
    public NodoHistorial getAnt() { return ant; }
    public void setAnt(NodoHistorial ant) { this.ant = ant; }
}
