package PruebaClases;

import PruebaLista.ListaDoblePaciente;
import PruebaLista.ListaDobleMedico;
import PruebaLista.ListaDobleHistorial;

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