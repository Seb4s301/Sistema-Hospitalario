
package Lista;

import Clases.Cita;
import Nodo.NodoAgendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListaDobleAgendar {
    private NodoAgendar ini;
    private NodoAgendar fin;
    private static ListaDobleAgendar lista;

    private ListaDobleAgendar() {
        ini = fin = null;
    }

    public static ListaDobleAgendar getInstancia() {
        if (lista == null) {
            lista = new ListaDobleAgendar();
        }
        return lista;
    }

    public void insertar(Cita dato) {
        NodoAgendar nuevo = new NodoAgendar(dato);
        
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public NodoAgendar getIni() {
        return ini;
    }

    public NodoAgendar getFin() {
        return fin;
    }

    public DefaultTableModel imprimirAgenda() {
        String columnas[] = {"DNI PACIENTE", "PACIENTE", "DNI MEDICO", "MEDICO", "ESPECIALIDAD", "FECHA/HORA"};

        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        NodoAgendar tmp = ini;

        while (tmp != null) {
            modelo.addRow(new Object[]{
                tmp.getDato().getDniPaciente(),
                tmp.getDato().getNombrePaciente() + " " + tmp.getDato().getApellidoPaciente(),
                tmp.getDato().getDniMedico(),
                tmp.getDato().getNombreMedico() + " " + tmp.getDato().getApellidoMedico(),
                tmp.getDato().getEspecialidad(),
                tmp.getDato().getFecha()
            });
            tmp = tmp.getSgte();
        }
        return modelo;
    }
}

