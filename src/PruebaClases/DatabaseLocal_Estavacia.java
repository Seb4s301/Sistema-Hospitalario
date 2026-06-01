package PruebaClases;

import PruebaLista.ListaDoblePaciente;
import PruebaLista.ListaDobleMedico;
import PruebaLista.ListaDobleHistorial_desarrollando;

/**
 *
 * @author Jean
 */
public class DatabaseLocal_Estavacia {
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
    public static ListaDobleHistorial_desarrollando listaHistoriales = new ListaDobleHistorial_desarrollando();
}