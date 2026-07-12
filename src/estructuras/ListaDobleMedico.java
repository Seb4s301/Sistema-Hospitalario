package estructuras;

import modelos.Medico;
import nodo.NodoMedico;

public class ListaDobleMedico {
    private NodoMedico ini;
    private NodoMedico fin;
    private static ListaDobleMedico instancia;

    private ListaDobleMedico() {
        this.ini = null;
        this.fin = null;
    }

    public static ListaDobleMedico getInstancia() {
        if (instancia == null) {
            instancia = new ListaDobleMedico();
        }
        return instancia;
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
    
    public Medico buscar(String dni) {
        NodoMedico actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                return actual.getDato();
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public boolean modificar(Medico MedicoModificado) {
        NodoMedico actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(MedicoModificado.getDni())) {
                //sobrescribe el objeto antiguo con el nuevo
                actual.setDato(MedicoModificado);
                return true; 
            }
            actual = actual.getSgte();
        }
        return false; 
    }
    

    public boolean eliminar(String dni) {
        NodoMedico actual = ini;
        //El que entiende entiende
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                
                if (actual == ini && actual == fin) {
                    ini = fin = null;
                }else if (actual == ini) {
                    ini = ini.getSgte();
                    ini.setAnt(null);
                }else if (actual == fin) {
                    fin = fin.getAnt();
                    fin.setSgte(null);
                }else {
                    actual.getAnt().setSgte(actual.getSgte());
                    actual.getSgte().setAnt(actual.getAnt());
                }
                return true; 
            }
            actual = actual.getSgte();
        }
        return false; 
    }
    
    // puente
    public java.util.ArrayList<modelos.Medico> obtenerTodos() {
        java.util.ArrayList<modelos.Medico> listaExportada = new java.util.ArrayList<>();
        nodo.NodoMedico actual = ini;
        
        while (actual != null) {
            listaExportada.add(actual.getDato());
            actual = actual.getSgte();
        }
        
        return listaExportada;
    }
    
}
