/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaClasesG;

import PruebaListaG.ListaDoblePaciente;
import PruebaListaG.ListaDobleMedico;
import PruebaListaG.ListaDobleHistorial;

/**
 *
 * @author Jean
 */
public class DatabaseLocal {
    public static final String[] Especialidades = {
        "Medicina General", 
        "Pediatria", 
        "Cardiologia", 
        "Dermatologia", 
        "Ginecologia", 
        "Traumatologia"
    };

    // Almacenamiento global en memoria de las listas dobles
    public static ListaDoblePaciente listaPacientes = new ListaDoblePaciente();
    public static ListaDobleMedico listaMedicos = new ListaDobleMedico();
    public static ListaDobleHistorial listaHistoriales = new ListaDobleHistorial();
}