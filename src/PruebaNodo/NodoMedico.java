/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaNodo;

import PruebaClases.Medico;

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

    
    
}
