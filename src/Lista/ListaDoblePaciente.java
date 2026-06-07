package Lista;

import Clases.Paciente;
import Nodo.NodoPaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */

public class ListaDoblePaciente {
    private NodoPaciente ini;
    private NodoPaciente fin;
    private static ListaDoblePaciente lista;
    
    private ListaDoblePaciente() {
        ini=fin=null;
    }

    public static ListaDoblePaciente getInstancia(){
        if(lista == null){
            lista = new ListaDoblePaciente();
        }
        return lista;
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
        String columnas[] = {"DNI","NOMBRES","APELLIDOS","FECHA NAC.","CELULAR","SEGURO"};
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
    
    public boolean modificar(String dni, String nuevosNombres, String nuevosApellidos, java.util.Date nuevaFecha, String nuevoCelular, String nuevoSeguro) {
        NodoPaciente nodo = buscar(dni);
        if (nodo != null) {
            ;
            nodo.getDato().setNombres(nuevosNombres);
            nodo.getDato().setApellidos(nuevosApellidos);
            nodo.getDato().setFechaNacimiento(nuevaFecha);
            nodo.getDato().setCelular(nuevoCelular);
            nodo.getDato().setSeguro(nuevoSeguro);
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
}