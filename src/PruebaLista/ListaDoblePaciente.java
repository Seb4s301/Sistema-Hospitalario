/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebaLista;

/**
 *
 * @author Jean
 */
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import PruebaNodo.NodoPaciente;
import PruebaClases.Paciente;

public class ListaDoblePaciente {
    NodoPaciente ini;
    NodoPaciente fin;

    public ListaDoblePaciente() {
        this.ini = null;
        this.fin = null;
    }

    public void insertar(Paciente dato) {
        NodoPaciente nuevo = new NodoPaciente(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    //Lista de columnas
    private String colPaciente[] = {
        "DNI", "Nombres", "Apellidos", "Fecha Nacimiento", "Celular", "Seguro"
    };

    public DefaultTableModel imprimirIDPaciente() {
        DefaultTableModel modeloPaciente = new DefaultTableModel(null, colPaciente);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (NodoPaciente tmp = ini; tmp != null; tmp = tmp.getSgte()) {
            String[] fila = new String[6];
            fila[0] = tmp.getDato().getDni();
            fila[1] = tmp.getDato().getNombres();
            fila[2] = tmp.getDato().getApellidos();
            fila[3] = (tmp.getDato().getFechaNacimiento() != null) ? sdf.format(tmp.getDato().getFechaNacimiento()) : "";
            fila[4] = tmp.getDato().getCelular();
            fila[5] = tmp.getDato().getSeguro();
            modeloPaciente.addRow(fila);
        }
        return modeloPaciente;
    }

    public boolean modificar(String dni, String nuevosNombres, String nuevosApellidos, java.util.Date nuevaFecha, String nuevoCelular, String nuevoSeguro) {
        NodoPaciente nodo = buscar(dni);
        if (nodo != null) {
            Paciente p = nodo.getDato();
            p.setNombres(nuevosNombres);
            p.setApellidos(nuevosApellidos);
            p.setFechaNacimiento(nuevaFecha);
            p.setCelular(nuevoCelular);
            p.setSeguro(nuevoSeguro);
            return true;
        }
        return false;
    }

    public void eliminarID(String dni) {
        NodoPaciente tmp = ini;
        while (tmp != null && !tmp.getDato().getDni().equals(dni)) {
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

    public NodoPaciente buscar(String dni) {
        NodoPaciente tmp = ini;
        while (tmp != null) {
            if (tmp.getDato().getDni().equals(dni)) {
                return tmp;
            }
            tmp = tmp.getSgte();
        }
        return null;
    }

    public NodoPaciente getIni() { return ini; }
}