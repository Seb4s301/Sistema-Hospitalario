/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaNodo;

import PruebaClases.HistorialClinico;

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

    
    
}
