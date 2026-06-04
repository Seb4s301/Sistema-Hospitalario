package PruebaLista;

import javax.swing.table.DefaultTableModel;
import PruebaClases.HistorialClinico;
import PruebaNodo.NodoHistorial;

/**
 *
 * @author Jean
 */

import PruebaClases.HistorialClinico;
import PruebaNodo.NodoHistorial;
import javax.swing.table.DefaultTableModel;

public class ListaDobleHistorial_desarrollando {
    private NodoHistorial ini;
    private NodoHistorial fin;

    public ListaDobleHistorial_desarrollando() {
        this.ini = null;
        this.fin = null;
    }

    public void insertar(HistorialClinico dato) {
        NodoHistorial nuevo = new NodoHistorial(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    private String colHistorial[] = {
        "DNI Paciente", "Tipo Sangre", "Alergias", "Enfermedades Cronicas", "Observaciones"
    };

    public DefaultTableModel imprimirIDHistorial() {
        DefaultTableModel modeloHistorial = new DefaultTableModel(null, colHistorial);
        
        for (NodoHistorial tmp = ini; tmp != null; tmp = tmp.getSgte()) {
            String[] fila = new String[5];
            fila[0] = String.valueOf(tmp.getDato().getDniPaciente());
            fila[1] = tmp.getDato().getTipoSangre();
            fila[2] = tmp.getDato().getAlergias();
            fila[3] = tmp.getDato().getEnfermedadesCronicas();
            fila[4] = tmp.getDato().getObservacionesMedicas();
            modeloHistorial.addRow(fila);
        }
        return modeloHistorial;
    }

    public boolean modificar(int dniPaciente, String nuevoTipoSangre,String nuevasAlergias, String nuevasEnfermedades,String nuevasObservaciones) {
        //Verifcar si historial existe
        NodoHistorial nodo = buscarPorDni(dniPaciente);

        if (nodo != null) {

            HistorialClinico h = nodo.getDato();

            if (!nuevoTipoSangre.trim().isEmpty()) {
                h.setTipoSangre(nuevoTipoSangre);
            }
            if (!nuevasAlergias.trim().isEmpty()) {
                h.setAlergias(nuevasAlergias);
            }
            if (!nuevasEnfermedades.trim().isEmpty()) {
                h.setEnfermedadesCronicas(nuevasEnfermedades);
            }
            if (!nuevasObservaciones.trim().isEmpty()) {
                h.setObservacionesMedicas(nuevasObservaciones);
            }
            return true;
        }
        return false;
    }

    public void eliminarID(int dniPaciente) {
        NodoHistorial tmp = ini;
        while (tmp != null && tmp.getDato().getDniPaciente() != dniPaciente) {
            tmp = tmp.getSgte();
        }
        if (tmp == null) return;

        if (ini == fin) {
            ini = fin = null;
        } else if (tmp == ini) {
            ini = ini.getSgte();
            ini.setAnt(null);
        } else if (tmp == fin) {
            fin = fin.getAnt();
            fin.setSgte(null);
        } else {
            tmp.getAnt().setSgte(tmp.getSgte());
            tmp.getSgte().setAnt(tmp.getAnt());
        }
    }

    public NodoHistorial buscarPorDni(int dniPaciente) {
        NodoHistorial tmp = ini;
        while (tmp != null) {
            if (tmp.getDato().getDniPaciente() == dniPaciente) {
                return tmp;
            }
            tmp = tmp.getSgte();
        }
        return null;
    }
}