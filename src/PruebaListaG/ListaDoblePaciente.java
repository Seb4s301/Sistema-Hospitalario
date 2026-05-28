package PruebaListaG;

import PruebaClasesG.Paciente;
import PruebaNodoG.NodoPaciente;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

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
            
        if (dato == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        // Si dni no tiene 8 caracteres
        if (dato.getDni() == null || dato.getDni().trim().length() != 8) {

            throw new IllegalArgumentException("DNI inválido.");
        }

        // validar celular 9 caracteres
        if (dato.getCelular() == null || dato.getCelular().trim().length() != 9) {

            throw new IllegalArgumentException("Celular inválido.");
        }
        
        NodoPaciente nuevo = new NodoPaciente(dato);
        if (ini == null) {
            ini = fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    private String colPaciente[] = {
        "DNI", "Nombres", "Apellidos", "Fecha Nacimiento", "Celular", "Seguro"
    };

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

    
    
    public boolean modificar(String dni,String nuevosNombres,String nuevosApellidos,String nuevaFecha,String nuevoCelular,String nuevoSeguro) {
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