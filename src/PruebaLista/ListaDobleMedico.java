package PruebaLista;

import PruebaClases.Medico;
import PruebaNodo.NodoMedico;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author Jean
 */

public class ListaDobleMedico {
    private NodoMedico ini;
    private NodoMedico fin;

    public ListaDobleMedico() {
        this.ini = null;
        this.fin = null;
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

    private String colMedico[] = {
        "DNI", "Nombres", "Apellidos", "Especialidad", "Fecha Nacimiento", "Celular", "Seguro"
    };

    public DefaultTableModel imprimirIDMedico() {
        DefaultTableModel modeloMedico = new DefaultTableModel(null, colMedico);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (NodoMedico tmp = ini; tmp != null; tmp = tmp.getSgte()) {
            String[] fila = new String[7];
            fila[0] = String.valueOf(tmp.getDato().getDni());
            fila[1] = tmp.getDato().getNombres();
            fila[2] = tmp.getDato().getApellidos();
            fila[3] = tmp.getDato().getEspecialidad();
            fila[4] = tmp.getDato().getFechaNacimiento() != null ? sdf.format(tmp.getDato().getFechaNacimiento()) : "";
            fila[5] = String.valueOf(tmp.getDato().getCelular()); // Mapeo de int a String para la tabla
            fila[6] = tmp.getDato().getSeguro();
            modeloMedico.addRow(fila);
        }
        return modeloMedico;
    }

    public boolean modificar(int dni, String nuevosNombres, String nuevosApellidos, java.util.Date nuevaFecha, int nuevoCelular, String nuevoSeguro, String nuevaEspecialidad) {
        NodoMedico nodo = buscar(dni);
        if (nodo != null) {
            Medico m = nodo.getDato();
            m.setNombres(nuevosNombres);
            m.setApellidos(nuevosApellidos);
            m.setFechaNacimiento(nuevaFecha);
            m.setCelular(nuevoCelular); // Asignacion como int
            m.setSeguro(nuevoSeguro);
            m.setEspecialidad(nuevaEspecialidad);
            return true;
        }
        return false;
    }

    public void eliminarID(int dni) {
        NodoMedico tmp = ini;
        while (tmp != null && tmp.getDato().getDni() != dni) {
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

    public NodoMedico buscar(int dni) {
        NodoMedico tmp = ini;
        while (tmp != null) {
            if (tmp.getDato().getDni() == dni) {
                return tmp;
            }
            tmp = tmp.getSgte();
        }
        return null;
    }
}