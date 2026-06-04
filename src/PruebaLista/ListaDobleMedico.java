package PruebaLista;

import PruebaNodo.NodoMedico;
import javax.swing.table.DefaultTableModel;
import PruebaClases.Medico;

/**
 *
 * @author Jean
 */

public class ListaDobleMedico {
    private NodoMedico ini;
    private NodoMedico fin;

    public ListaDobleMedico() {
        ini=fin=null;
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

    public DefaultTableModel imprimirIDMedico() {
        String columnas[] = {
            "DNI",
            "NOMBRES",
            "APELLIDOS",
            "FECHA NAC.",
            "CELULAR",
            "ESPECIALIDAD"
        };
        
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        
        NodoMedico tmp = ini;
        
        while (tmp != null) {
            modelo.addRow(new Object[]{
                tmp.getDato().getDni(),
                tmp.getDato().getNombres(),
                tmp.getDato().getApellidos(),
                tmp.getDato().getFechaNacimiento(),
                tmp.getDato().getCelular(),
                tmp.getDato().getEspecialidad()
            });
            tmp = tmp.getSgte();
        }
        return modelo;
    }

    public boolean modificar(String dni,String nuevosNombres,String nuevosApellidos,String nuevaFecha,String nuevoCelular,String nuevaEspecialidad) {

        //Verificacion de que el medico existe
        NodoMedico nodo = buscar(dni);

        if (nodo != null) {

            Medico m = nodo.getDato();
            //Si el valor de la variable tratando de modificar:
            //esta vacia -> true -> false = NO entra
            //esta llena -> false -> true = entra y modifica el valor de la variable anterior por la nueva
            if (!nuevosNombres.trim().isEmpty()) {
                m.setNombres(nuevosNombres);
            }
            if (!nuevosApellidos.trim().isEmpty()) {
                m.setApellidos(nuevosApellidos);
            }
            if (!nuevaFecha.replace("/", "").trim().isEmpty()) {
                m.setFechaNacimiento(nuevaFecha);
            }
            if (!nuevoCelular.trim().isEmpty()) {
                m.setCelular(nuevoCelular);
            }
            if (!nuevaEspecialidad.trim().isEmpty()) {
                m.setEspecialidad(nuevaEspecialidad);
            }
            return true;
        }
        return false;
    }

    public void eliminarID(String dni) {
        NodoMedico tmp = ini;
        
        //El que entiende entiende
        while (tmp != null &&
                !tmp.getDato().getDni().equals(dni)) {
            tmp = tmp.getSgte();
        }
        if (tmp == null) {
            return;
        }
        if (ini == fin) {
            ini = fin = null;
        } else if (tmp == ini) {
            ini = ini.getSgte();
            ini.setAnt(null);
        } else if (tmp == fin) {
            fin = fin.getAnt();
            fin.setSgte(null);
        } else {
            tmp.getAnt().setSgte(
                    tmp.getSgte());
            tmp.getSgte().setAnt(
                    tmp.getAnt());
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
}