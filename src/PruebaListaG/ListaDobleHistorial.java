/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaListaG;

import javax.swing.table.DefaultTableModel;
import PruebaClasesG.HistorialClinico;
import PruebaNodoG.NodoHistorial;

/**
 *
 * @author Jean
 */

import PruebaClasesG.HistorialClinico;
import PruebaNodoG.NodoHistorial;
import javax.swing.table.DefaultTableModel;

public class ListaDobleHistorial {
    private NodoHistorial ini;
    private NodoHistorial fin;

    public ListaDobleHistorial() {
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

    public boolean modificar(int dniPaciente, String nuevoTipoSangre, String nuevasAlergias, String nuevasEnfermedades, String nuevasObservaciones) {
        NodoHistorial nodo = buscarPorDni(dniPaciente);
        if (nodo != null) {
            HistorialClinico h = nodo.getDato();
            h.setTipoSangre(nuevoTipoSangre);
            h.setAlergias(nuevasAlergias);
            h.setEnfermedadesCronicas(nuevasEnfermedades);
            h.setObservacionesMedicas(nuevasObservaciones);
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