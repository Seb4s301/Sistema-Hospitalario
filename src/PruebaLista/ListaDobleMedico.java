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
import prueba1.Medico;
import prueba1.NodoMedico;

public class ListaDobleMedico {
    NodoMedico ini;
    NodoMedico fin;

    public ListaDobleMedico() {
        this.ini = fin = null;
    }

    public void insertar(Medico dato) {
        NodoMedico nuevo = new NodoMedico(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }
    //Lista de columnas
    private String colMedico[] = {
        "DNI", "Nombres", "Apellidos", "Especialidad", "Fecha Nacimiento", "Celular", "Seguro"
    };

    public DefaultTableModel imprimirIDMedico() {
        DefaultTableModel modeloMedico = new DefaultTableModel(null, colMedico);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (NodoMedico tmp = ini; tmp != null; tmp = tmp.getSgte()) {
            String[] fila = new String[7];
            fila[0] = tmp.getDato().getDni();
            fila[1] = tmp.getDato().getNombres();
            fila[2] = tmp.getDato().getApellidos();
            fila[3] = tmp.getDato().getEspecialidad();
            fila[4] = (tmp.getDato().getFechaNacimiento() != null) ? sdf.format(tmp.getDato().getFechaNacimiento()) : "";
            fila[5] = tmp.getDato().getCelular();
            fila[6] = tmp.getDato().getSeguro();
            modeloMedico.addRow(fila);
        }
        return modeloMedico;
    }

    public boolean modificar(String dni, String nuevosNombres, String nuevosApellidos, java.util.Date nuevaFecha, String nuevoCelular, String nuevoSeguro, String nuevaEspecialidad) {
        NodoMedico nodo = buscar(dni);
        if (nodo != null) {
            Medico m = nodo.getDato();
            m.setNombres(nuevosNombres);
            m.setApellidos(nuevosApellidos);
            m.setFechaNacimiento(nuevaFecha);
            m.setCelular(nuevoCelular);
            m.setSeguro(nuevoSeguro);
            m.setEspecialidad(nuevaEspecialidad);
            return true;
        }
        return false;
    }

    public void eliminarID(String dni) {
        NodoMedico tmp = ini;
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

    public NodoMedico buscar(String dni) {
        NodoMedico tmp = ini;
        while (tmp != null) {
            if (tmp.getDato().getDni().equals(dni)) {
                return tmp;
            }
            tmp = tmp.getSgte();
        }
        return null;
    }

    public NodoMedico getIni() { return ini; }
}