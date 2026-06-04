package PruebaLista;

import PruebaClases.Paciente;
import PruebaNodo.NodoPaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */

public class ListaDoblePaciente {
    private NodoPaciente ini;
    private NodoPaciente fin;

    public ListaDoblePaciente() {
        ini=fin=null;
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



    public DefaultTableModel imprimirIDPaciente() {
        String columnas[] = {
            "DNI",
            "NOMBRES",
            "APELLIDOS",
            "FECHA NAC.",
            "CELULAR",
            "SEGURO"
        };
        
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
         
        NodoPaciente tmp = ini;
        
        while (tmp != null) {
            modelo.addRow(new Object[]{
                tmp.getDato().getDni(),
                tmp.getDato().getNombres(),
                tmp.getDato().getApellidos(),
                tmp.getDato().getFechaNacimiento(),
                tmp.getDato().getCelular(),
                tmp.getDato().getSeguro()
            });
            tmp = tmp.getSgte();
        }
        return modelo;
    }
    
    public boolean modificar(String dni, String nuevosNombres,String nuevosApellidos, String nuevaFecha,String nuevoCelular, String nuevoSeguro) {

        NodoPaciente nodo = buscar(dni);

        if (nodo != null) {
            //Verificamos de que el paciente existe
            Paciente p = nodo.getDato();
            //Si el valor de la variable tratando de modificar:
            //esta vacia -> true -> false = NO entra
            //esta llena -> false -> true = entra y modifica el valor de la variable anterior por la nueva
            if (!nuevosNombres.trim().isEmpty()) {
                p.setNombres(nuevosNombres);
            }
            if (!nuevosApellidos.trim().isEmpty()) {
                p.setApellidos(nuevosApellidos);
            }
            if (!nuevaFecha.replace("/", "").trim().isEmpty()) {
                p.setFechaNacimiento(nuevaFecha);
            }
            if (!nuevoCelular.trim().isEmpty()) {
                p.setCelular(nuevoCelular);
            }
            if (!nuevoSeguro.trim().isEmpty()) {
                p.setSeguro(nuevoSeguro);
            }
            return true;
        }

        return false;
    }

    public void eliminarID(String dni) {
        NodoPaciente tmp = ini;
        
        //El que entiende entiende
        while (tmp != null) {
            if (tmp.getDato().getDni().equals(dni)) {

                if (tmp == ini) {
                    ini = ini.getSgte();
                    if (ini != null) {
                        ini.setAnt(null);
                    }
                } else if (tmp == fin) {
                    fin = fin.getAnt();
                    if (fin != null) {
                        fin.setSgte(null);
                    }
                } else {
                    tmp.getAnt().setSgte(tmp.getSgte());
                    tmp.getSgte().setAnt(tmp.getAnt());
                }
                return;
            }
            tmp = tmp.getSgte();
        }
    }

    public NodoPaciente buscar(String dni) {
        NodoPaciente aux = ini;
        while (aux != null) {
            if (aux.getDato().getDni().equals(dni)) {
                return aux;
            }
            aux = aux.getSgte();
        }
        return null;
    }
}