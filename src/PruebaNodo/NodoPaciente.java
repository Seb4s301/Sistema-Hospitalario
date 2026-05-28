/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaNodo;

import PruebaClases.Paciente;

/**
 *
 * @author Jean
 */
public class NodoPaciente {
    Paciente dato;
    NodoPaciente sgte;
    NodoPaciente ant;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Paciente getDato() { return dato; }
    public void setDato(Paciente dato) { this.dato = dato; }
    public NodoPaciente getSgte() { return sgte; }
    public void setSgte(NodoPaciente sgte) { this.sgte = sgte; }
    public NodoPaciente getAnt() { return ant; }
    public void setAnt(NodoPaciente ant) { this.ant = ant; }
}
